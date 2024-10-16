package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}