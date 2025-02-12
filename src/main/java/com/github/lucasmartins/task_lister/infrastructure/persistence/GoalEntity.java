package com.github.lucasmartins.task_lister.infrastructure.persistence;

import com.github.lucasmartins.task_lister.domain.model.enums.GoalStatusEnum;
import com.github.lucasmartins.task_lister.domain.model.enums.FrequencyEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "goal")
public class GoalEntity {

    @Id
    @GeneratedValue(generator = "goal_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GoalStatusEnum goalStatusEnum;

    @ManyToOne
    @JoinColumn(name = "goal_type_id")
    private GoalTypeEntity goalTypeEntity;

    @Column(nullable = false)
    private int interval;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FrequencyEnum frequencyEnum;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "goalEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> taskEntities;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

}
