package com.github.lucasmartins.task_lister.domain.model;

import com.github.lucasmartins.task_lister.domain.model.enums.Frequency;
import com.github.lucasmartins.task_lister.domain.model.enums.GoalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(generator = "goal_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GoalStatus goalStatus;

    @ManyToOne
    @JoinColumn(name = "goal_type_id")
    private GoalType goalType;

    @Column(nullable = false)
    private int interval;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
