package dev.maximilian.backend.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "webpages")
@Data
public class Webpage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;

}
