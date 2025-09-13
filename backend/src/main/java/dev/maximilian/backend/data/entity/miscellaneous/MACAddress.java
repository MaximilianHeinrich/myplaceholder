package dev.maximilian.backend.data.entity.miscellaneous;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mac_addresses")
@Data
public class MACAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mac;
    private String vendor;

}
