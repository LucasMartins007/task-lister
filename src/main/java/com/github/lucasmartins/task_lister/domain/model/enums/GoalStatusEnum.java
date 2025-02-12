package com.github.lucasmartins.task_lister.domain.model.enums;

import lombok.Getter;

@Getter
public enum GoalStatusEnum {

    IN_PROGRESS(1, "In Progress"),

    RUNNING(2, "Running"),

    COMPLETED(3, "Completed"),

    CANCELED(4, "Canceled");

    private final int key;

    private final String description;

    GoalStatusEnum(int key, String description) {
        this.key = key;
        this.description = description;
    }
}
