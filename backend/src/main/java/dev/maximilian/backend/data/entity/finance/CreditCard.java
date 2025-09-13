package dev.maximilian.backend.data.entity.finance;

import dev.maximilian.backend.data.model.CardType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "finances")
@Data
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    private String number;
    private String creditCardExpiry;
    private String cvv;
    private String cardHolderName;
    private Double creditLimit;
    private Double balance;
    private String bankName;

}
