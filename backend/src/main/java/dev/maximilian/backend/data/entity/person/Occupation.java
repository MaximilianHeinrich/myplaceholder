package dev.maximilian.backend.data.entity.person;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "occupations")
@Data
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double salary;
    private String companyName;
    private String department;

}
