package com.github.lucasmartins.task_lister.domain.repository;

import com.github.lucasmartins.task_lister.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
