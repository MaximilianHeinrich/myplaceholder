package dev.maximilian.backend.data.entity.miscellaneous;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendors")
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String registry;
    @Column(length = 1000)
    private String assignment;
    @Column(length = 1000)
    private String organizationName;
    @Column(length = 2000)
    private String organizationAddress;

}
