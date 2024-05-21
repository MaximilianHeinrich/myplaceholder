package dev.maximilian.backend.data.entity;

import dev.maximilian.backend.data.model.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private int quantity;
    private OrderStatus status;

}
