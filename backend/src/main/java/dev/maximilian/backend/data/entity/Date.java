package dev.maximilian.backend.data.entity;

import dev.maximilian.backend.data.model.DateFormat;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dates")
@Data
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private int month;
    private int year;
    private DateFormat format;

}
