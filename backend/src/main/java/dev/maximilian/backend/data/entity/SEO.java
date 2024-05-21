package dev.maximilian.backend.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "seos")
@Data
public class SEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String metaDescription;
    private String metaKeywords;
    private String utmSource;
    private String utmMedium;
    private String utmCampaign;

}
