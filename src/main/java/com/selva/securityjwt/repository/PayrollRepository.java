package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}