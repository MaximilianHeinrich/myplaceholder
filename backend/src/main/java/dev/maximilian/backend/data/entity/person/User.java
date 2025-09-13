package dev.maximilian.backend.data.entity.person;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long username;
    private String email;
    private String password; // Hashed password
    private String role;

}
