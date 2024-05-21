package dev.maximilian.backend.data.entity;

import dev.maximilian.backend.data.model.Gender;
import dev.maximilian.backend.data.model.Unit;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private double height;
    private Unit heightUnit;
    private double weight;
    private Unit weightUnit;

}
