package dev.maximilian.backend.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "systems")
@Data
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appVersion;
    private String serverTime;
    private String serverTimezone;
    private String serverName;

}
