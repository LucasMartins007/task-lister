package com.github.lucasmartins.task_lister.application.dto.request;

import com.github.lucasmartins.task_lister.domain.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {

    private String username;

    private String password;

    private String email;

    public static User toDomain(UserRequest userRequest) {
        return User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }

}
