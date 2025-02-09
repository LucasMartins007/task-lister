package com.github.lucasmartins.task_lister.domain.repository;

import com.github.lucasmartins.task_lister.domain.model.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalTypeRepository extends JpaRepository<GoalType, Integer> {
}
