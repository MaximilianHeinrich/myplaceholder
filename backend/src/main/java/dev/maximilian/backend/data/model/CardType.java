package dev.maximilian.backend.data.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CardType {

    VISA("Visa"),
    MASTERCARD("MasterCard"),
    AMERICAN_EXPRESS("American Express"),
    DISCOVER("Discover");

    private final String displayName;

}
