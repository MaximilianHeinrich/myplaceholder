package dev.maximilian.backend.repository.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaCurrencyRepository")
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
