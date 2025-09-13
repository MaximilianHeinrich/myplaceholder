package dev.maximilian.backend.data.entity.ecommerce;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "currencies")
@Data
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String demonym;
    private String majorSingle;
    private String majorPlural;
    private int ISOnum;
    private String symbol;
    private String symbolNative;
    private String minorSingle;
    private String minorPlural;
    private int ISOdigits;
    private int decimals;
    private int numToBasic;

}
