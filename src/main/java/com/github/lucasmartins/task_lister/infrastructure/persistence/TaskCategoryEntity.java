package com.github.lucasmartins.task_lister.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "task_category")
public class TaskCategoryEntity {

    @Id
    @GeneratedValue(generator = "task_category_id_sequence", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String description;

}
