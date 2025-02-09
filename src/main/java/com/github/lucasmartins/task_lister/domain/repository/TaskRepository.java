package com.github.lucasmartins.task_lister.domain.repository;

import com.github.lucasmartins.task_lister.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
