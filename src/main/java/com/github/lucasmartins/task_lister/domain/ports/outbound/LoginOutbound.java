package com.github.lucasmartins.task_lister.domain.ports.outbound;

import com.github.lucasmartins.task_lister.infrastructure.adapter.outbound.repository.UserRepository;
import com.github.lucasmartins.task_lister.infrastructure.persistence.UserEntity;

import java.util.Optional;

public interface LoginOutbound extends UserRepository {

    Optional<UserEntity> findByUsername(String username);

}
