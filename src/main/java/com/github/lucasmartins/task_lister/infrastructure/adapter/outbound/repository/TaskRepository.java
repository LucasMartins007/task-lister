package com.github.lucasmartins.task_lister.infrastructure.adapter.outbound.repository;

import com.github.lucasmartins.task_lister.infrastructure.persistence.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
