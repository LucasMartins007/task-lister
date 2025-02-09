package com.github.lucasmartins.task_lister.domain.model.enums;

import lombok.Getter;

@Getter
public enum Frequency {

    WEEKLY(1, "Weekly"),

    MONTHLY(2, "Monthly");

    private final int key;

    private final String description;

    Frequency(int key, String description) {
        this.key = key;
        this.description = description;
    }
}
