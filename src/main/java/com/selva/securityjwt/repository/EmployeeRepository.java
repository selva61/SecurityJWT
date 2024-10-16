package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}