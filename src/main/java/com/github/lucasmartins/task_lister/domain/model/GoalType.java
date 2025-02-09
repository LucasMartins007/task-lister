package com.github.lucasmartins.task_lister.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "goal_type")
public class GoalType {

    @Id
    @GeneratedValue(generator = "goal_type_id_sequence", strategy = GenerationType.SEQUENCE)
    private int id;

    private String description;
}
