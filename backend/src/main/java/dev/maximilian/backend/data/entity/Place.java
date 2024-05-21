package dev.maximilian.backend.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "places")
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private int zipCode;
    private String street;
    private int houseNumber;

}
