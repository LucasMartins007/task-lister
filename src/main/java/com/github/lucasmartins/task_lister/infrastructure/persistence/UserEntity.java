package com.github.lucasmartins.task_lister.infrastructure.persistence;

import com.github.lucasmartins.task_lister.domain.model.abstractions.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity implements AbstractEntity {

    @Id
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<GoalEntity> goalEntities;


}
