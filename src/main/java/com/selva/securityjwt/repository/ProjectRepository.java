package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}