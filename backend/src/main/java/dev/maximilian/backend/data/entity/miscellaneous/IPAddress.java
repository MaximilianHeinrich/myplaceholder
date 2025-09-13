package dev.maximilian.backend.data.entity.miscellaneous;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ip_addresses")
@Data
public class IPAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ip;
    private String type;

}
