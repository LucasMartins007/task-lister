package com.github.lucasmartins.task_lister.infrastructure.adapter.inbound.controller;

import com.github.lucasmartins.task_lister.application.core.usecase.LoginUseCase;
import com.github.lucasmartins.task_lister.application.dto.request.UserRequest;
import com.github.lucasmartins.task_lister.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("login")
@RequiredArgsConstructor
public class LoginController {


    private final LoginUseCase loginUseCase;

    @PostMapping
    public void login(@RequestBody UserRequest userRequest) {
        final User user = loginUseCase.login(UserRequest.toDomain(userRequest));

        loginUseCase.login(user);
    }
}
