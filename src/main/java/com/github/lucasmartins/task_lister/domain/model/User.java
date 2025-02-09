package com.github.lucasmartins.task_lister.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Goal> goals;


}
