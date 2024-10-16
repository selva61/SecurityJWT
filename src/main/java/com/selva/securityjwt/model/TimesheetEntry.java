package com.selva.securityjwt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "timesheet_entries")
public class TimesheetEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timesheet_entries_id_gen")
    @SequenceGenerator(name = "timesheet_entries_id_gen", sequenceName = "timesheet_entries_entry_id_seq", allocationSize = 1)
    @Column(name = "entry_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @NotNull
    @Column(name = "date_worked", nullable = false)
    private LocalDate dateWorked;

    @NotNull
    @Column(name = "hours_worked", nullable = false, precision = 4, scale = 2)
    private BigDecimal hoursWorked;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public LocalDate getDateWorked() {
        return dateWorked;
    }

    public void setDateWorked(LocalDate dateWorked) {
        this.dateWorked = dateWorked;
    }

    public BigDecimal getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(BigDecimal hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}