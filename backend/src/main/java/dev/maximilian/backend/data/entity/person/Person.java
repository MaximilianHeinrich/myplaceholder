package dev.maximilian.backend.data.entity.person;

import dev.maximilian.backend.data.model.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Transient
    private Integer age;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "occupation_id", referencedColumnName = "id")
    private Occupation occupation;
    private String profilePictureUrl;
    private LocalDate createdAt;

}
