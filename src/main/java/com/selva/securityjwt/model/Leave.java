package com.selva.securityjwt.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private int bal_annual_leave;
    private int bal_sick_leave;
    private int bal_child_care_leave;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getBal_annual_leave() {
        return bal_annual_leave;
    }

    public void setBal_annual_leave(int balance_annual_leave) {
        this.bal_annual_leave = balance_annual_leave;
    }

    public int getBal_sick_leave() {
        return bal_sick_leave;
    }

    public void setBal_sick_leave(int balance_sick_leave) {
        this.bal_sick_leave = balance_sick_leave;
    }

    public int getBal_child_care_leave() {
        return bal_child_care_leave;
    }

    public void setBal_child_care_leave(int balance_child_care_leave) {
        this.bal_child_care_leave = balance_child_care_leave;
    }
}
