package com.github.lucasmartins.task_lister.domain.model;

import com.github.lucasmartins.task_lister.domain.model.abstractions.AbstractDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User implements AbstractDomain {

    private int id;

    private String username;

    private String password;

    private String email;
}
