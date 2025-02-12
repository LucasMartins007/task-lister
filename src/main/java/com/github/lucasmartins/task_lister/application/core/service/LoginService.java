package com.github.lucasmartins.task_lister.application.core.service;

import com.github.lucasmartins.task_lister.application.core.usecase.LoginUseCase;
import com.github.lucasmartins.task_lister.domain.model.User;
import com.github.lucasmartins.task_lister.domain.model.abstractions.AbstractService;
import com.github.lucasmartins.task_lister.domain.ports.outbound.LoginOutbound;
import com.github.lucasmartins.task_lister.infrastructure.persistence.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService extends AbstractService<UserEntity, User> implements LoginUseCase {

    private final LoginOutbound loginOutbound;

    @Override
    public User login(User user) {
        final UserEntity userEntity = loginOutbound.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("error.."));

        return convertToDomain(userEntity);
    }
}
