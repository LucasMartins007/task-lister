package com.github.lucasmartins.task_lister.domain.repository;

import com.github.lucasmartins.task_lister.domain.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer> {
}
