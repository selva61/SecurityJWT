package com.selva.securityjwt.DTO;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.selva.securityjwt.model.Timesheet}
 */
public class TimesheetDTO implements Serializable {
    private final Long id;
    @NotNull
    private final Instant date;
    @NotNull
    private final Double hoursWorked;

    public TimesheetDTO(Long id, Instant date, Double hoursWorked) {
        this.id = id;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public Long getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimesheetDTO entity = (TimesheetDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.hoursWorked, entity.hoursWorked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, hoursWorked);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "date = " + date + ", " +
                "hoursWorked = " + hoursWorked + ")";
    }
}