package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
}