package dev.maximilian.backend.data.entity.ecommerce;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ecommerce")
@Data
public class ECommerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;
    private Integer quantity;
    private String description;
    private boolean inStock;

}
