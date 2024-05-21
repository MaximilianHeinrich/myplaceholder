package dev.maximilian.backend.data.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public enum Unit {

    METER("Meter"),
    ZENTIMETER("Zentimeter"),
    FEET("Feet"),
    INCH("Inch"),
    KILOGRAM("Kilogram"),
    GRAM("Gram"),
    POUND("Pound"),
    OUNCE("Ounce");

    @Getter
    @Setter
    private final String unit;

}
