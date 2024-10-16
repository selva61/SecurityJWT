package com.selva.securityjwt.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double salary;
    private LocalDate payDate;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }



    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
