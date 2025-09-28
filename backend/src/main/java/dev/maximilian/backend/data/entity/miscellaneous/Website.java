package dev.maximilian.backend.data.entity.miscellaneous;

import dev.maximilian.backend.data.entity.person.Person;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "websites")
@Data
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;

}
