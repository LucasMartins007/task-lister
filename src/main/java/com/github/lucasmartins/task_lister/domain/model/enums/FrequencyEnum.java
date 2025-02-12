package com.github.lucasmartins.task_lister.domain.model.enums;

import lombok.Getter;

@Getter
public enum FrequencyEnum {

    WEEKLY(1, "Weekly"),

    MONTHLY(2, "Monthly");

    private final int key;

    private final String description;

    FrequencyEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }
}
