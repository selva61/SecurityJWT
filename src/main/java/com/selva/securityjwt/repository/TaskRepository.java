package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}