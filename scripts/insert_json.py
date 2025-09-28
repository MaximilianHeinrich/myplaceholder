import json
import psycopg2
import re
import sys


def camel_to_snake(name: str) -> str:
    s1 = re.sub(r'([A-Z]+)([A-Z][a-z])', r'\1_\2', name)
    s2 = re.sub(r'([a-z0-9])([A-Z])', r'\1_\2', s1)
    return s2.lower()


def normalize_keys(record: dict) -> dict:
    """Convert all keys in a record to snake_case."""
    return {camel_to_snake(k): v for k, v in record.items()}


def get_not_null_columns(cur, table_name):
    cur.execute("""
                SELECT column_name, data_type
                FROM information_schema.columns
                WHERE table_name = %s
                  AND is_nullable = 'NO'
                """, (table_name,))
    return {row[0]: row[1] for row in cur.fetchall()}


def get_primary_keys(cur, table_name):
    cur.execute("""
                SELECT a.attname
                FROM pg_index i
                         JOIN pg_attribute a ON a.attrelid = i.indrelid AND a.attnum = ANY (i.indkey)
                WHERE i.indrelid = %s::regclass AND i.indisprimary
                """, (table_name,))
    return [row[0] for row in cur.fetchall()]


def main():
    if len(sys.argv) != 3:
        print("Usage: python insert_json.py <json_file> <table_name>")
        sys.exit(1)

    json_file = sys.argv[1]
    table_name = sys.argv[2]

    DB_CONFIG = {
        "dbname": "placeholder",  # replace with your DB name
        "user": "postgres",  # replace with your DB user
        "password": "password",  # replace with your DB password
        "host": "localhost",  # or your DB host
        "port": 5432  # default Postgres port
    }

    with open(json_file, "r", encoding="utf-8") as f:
        data = json.load(f)

    if isinstance(data, dict):
        records = list(data.values())
    elif isinstance(data, list):
        records = data
    else:
        print("❌ JSON format not supported. Use a list or dict of records.")
        sys.exit(1)

    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    not_null_cols = get_not_null_columns(cur, table_name)
    primary_keys = get_primary_keys(cur, table_name)

    for record in records:
        record = normalize_keys(record)

        for col, dtype in not_null_cols.items():
            if col in primary_keys:
                continue
            if col not in record or record[col] is None:
                if dtype in ('integer', 'bigint', 'smallint', 'numeric', 'real', 'double precision'):
                    record[col] = 0
                else:
                    record[col] = ''

        keys = list(record.keys())
        values = list(record.values())

        columns = ", ".join(keys)
        placeholders = ", ".join(["%s"] * len(keys))

        sql = f"INSERT INTO {table_name} ({columns}) VALUES ({placeholders})"
        cur.execute(sql, values)

    conn.commit()
    cur.close()
    conn.close()

    print(f"✅ Inserted {len(records)} records into table '{table_name}'")


if __name__ == "__main__":
    main()
