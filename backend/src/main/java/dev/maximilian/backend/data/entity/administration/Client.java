package dev.maximilian.backend.data.entity.administration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//TODO: Env variable for development
//TODO: Confirmation email sending
//TODO: Regex
//TODO: Self cleanup of unverified clients after a certain period
@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @JsonIgnore
    @Column(nullable = false, length = 1000)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true)
    private String apiKey;
    private String verificationId;
    private boolean verified;

    @PrePersist
    public void prePersist() {
        if (apiKey == null) {
            apiKey = UUID.randomUUID().toString();
        }
        if (verificationId == null) {
            verificationId = UUID.randomUUID().toString();
        }
    }

}
