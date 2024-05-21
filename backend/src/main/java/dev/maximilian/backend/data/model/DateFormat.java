package dev.maximilian.backend.data.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public enum DateFormat {

    DMY("dd.MM.yyyy"),
    YMD("yyyy-MM-dd"),
    MDY("MM/dd/yyyy");

    @Getter
    @Setter
    private final String format;

}
