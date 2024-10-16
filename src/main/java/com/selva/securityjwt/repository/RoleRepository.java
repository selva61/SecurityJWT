package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}