package com.github.lucasmartins.task_lister.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(generator = "task_id_sequence", strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_category_id")
    private TaskCategory taskCategory;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Goal goal;
}
