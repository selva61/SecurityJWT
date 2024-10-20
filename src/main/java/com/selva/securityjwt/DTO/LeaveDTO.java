package com.selva.securityjwt.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.selva.securityjwt.model.Leave}
 */
public class LeaveDTO implements Serializable {
    private final Long id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String type;
    private final int balance_annual_leave;
    private final int balance_sick_leave;
    private final int balance_child_care_leave;

    public LeaveDTO(Long id, LocalDate startDate, LocalDate endDate, String type, int balance_annual_leave, int balance_sick_leave, int balance_child_care_leave) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.balance_annual_leave = balance_annual_leave;
        this.balance_sick_leave = balance_sick_leave;
        this.balance_child_care_leave = balance_child_care_leave;

    }

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getType() {
        return type;
    }

    public int getBalance_annual_leave() {
        return balance_annual_leave;
    }

    public int getBalance_sick_leave() {
        return balance_sick_leave;
    }

    public int getBalance_child_care_leave() {
        return balance_child_care_leave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveDTO entity = (LeaveDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.balance_annual_leave, entity.balance_annual_leave) &&
                Objects.equals(this.balance_sick_leave, entity.balance_sick_leave) &&
                Objects.equals(this.balance_child_care_leave, entity.balance_child_care_leave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, type);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "startDate = " + startDate + ", " +
                "endDate = " + endDate + ", " +
                "type = " + type + ") " + ", " +
                "balance_annual_leave = " + balance_annual_leave + ", " +
                "balance_sick_leave = " + balance_sick_leave + ", " +
                "balance_child_care_leave = " + balance_child_care_leave + ")";
    }
}