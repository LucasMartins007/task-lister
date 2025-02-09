package com.github.lucasmartins.task_lister.domain.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum GoalStatus {

    IN_PROGRESS(1, "In Progress"),

    RUNNING(2, "Running"),

    COMPLETED(3, "Completed"),

    CANCELED(4, "Canceled");

    private final int key;

    private final String description;

    GoalStatus(int key, String description) {
        this.key = key;
        this.description = description;
    }
}
