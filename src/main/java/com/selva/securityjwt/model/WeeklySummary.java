package com.selva.securityjwt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "weekly_summaries")
public class WeeklySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weekly_summaries_id_gen")
    @SequenceGenerator(name = "weekly_summaries_id_gen", sequenceName = "weekly_summaries_summary_id_seq", allocationSize = 1)
    @Column(name = "summary_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @NotNull
    @Column(name = "week_start_date", nullable = false)
    private LocalDate weekStartDate;

    @NotNull
    @Column(name = "total_hours", nullable = false, precision = 5, scale = 2)
    private BigDecimal totalHours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(LocalDate weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public BigDecimal getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(BigDecimal totalHours) {
        this.totalHours = totalHours;
    }

}