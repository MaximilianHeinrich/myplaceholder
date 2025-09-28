package dev.maximilian.backend.repository.finance;

import dev.maximilian.backend.data.entity.finance.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaCreditCardRepository")
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
