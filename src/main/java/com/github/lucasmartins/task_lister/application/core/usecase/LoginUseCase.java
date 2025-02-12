package com.github.lucasmartins.task_lister.application.core.usecase;

import com.github.lucasmartins.task_lister.domain.model.User;

public interface LoginUseCase {

    User login(User user);
}
