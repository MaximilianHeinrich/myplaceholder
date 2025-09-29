package dev.maximilian.backend.repository.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaCurrencyRepository")
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByName(String name);
    Optional<Currency> findBySymbol(String symbol);
    List<Currency> findByIsOnum(int isOnum);
    List<Currency> findByDecimals(int decimals);
    @Query("SELECT c.symbol FROM Currency c")
    List<String> findAllCurrencySymbols();

}
