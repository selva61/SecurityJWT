package com.selva.securityjwt.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.selva.securityjwt.model.Payroll}
 */
public class PayrollDTO implements Serializable {
    private final Long id;
    private final Double salary;
    private final LocalDate payDate;

    public PayrollDTO(Long id, Double salary, LocalDate payDate) {
        this.id = id;
        this.salary = salary;
        this.payDate = payDate;
    }

    public Long getId() {
        return id;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayrollDTO entity = (PayrollDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.salary, entity.salary) &&
                Objects.equals(this.payDate, entity.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, payDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "salary = " + salary + ", " +
                "payDate = " + payDate + ")";
    }
}