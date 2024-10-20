package com.selva.securityjwt.DTO;

import jakarta.validation.constraints.Email;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.selva.securityjwt.model.Employee}
 */
public class EmployeeDTO implements Serializable {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final String zip;
    @Email
    private final String department;
    private final String designation;
    private final String status;
    private final List<RoleDTO> roles;
    private final List<PayrollDTO> payrolls;
    private final List<LeaveDTO> leaves;
    private final List<TimesheetDTO> timesheets;

    public EmployeeDTO(Long id, String firstName, String lastName, String email, String phone, String address, String city, String state, String country, String zip, String department, String designation, String status, List<RoleDTO> roles, List<PayrollDTO> payrolls, List<LeaveDTO> leaves, List<TimesheetDTO> timesheets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.department = department;
        this.designation = designation;
        this.status = status;
        this.roles = roles;
        this.payrolls = payrolls;
        this.leaves = leaves;
        this.timesheets = timesheets;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getStatus() {
        return status;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public List<PayrollDTO> getPayrolls() {
        return payrolls;
    }

    public List<LeaveDTO> getLeaves() {
        return leaves;
    }

    public List<TimesheetDTO> getTimesheets() {
        return timesheets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.state, entity.state) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.zip, entity.zip) &&
                Objects.equals(this.department, entity.department) &&
                Objects.equals(this.designation, entity.designation) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.roles, entity.roles) &&
                Objects.equals(this.payrolls, entity.payrolls) &&
                Objects.equals(this.leaves, entity.leaves) &&
                Objects.equals(this.timesheets, entity.timesheets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone, address, city, state, country, zip, department, designation, status, roles, payrolls, leaves, timesheets);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "phone = " + phone + ", " +
                "address = " + address + ", " +
                "city = " + city + ", " +
                "state = " + state + ", " +
                "country = " + country + ", " +
                "zip = " + zip + ", " +
                "department = " + department + ", " +
                "designation = " + designation + ", " +
                "status = " + status + ", " +
                "roles = " + roles + ", " +
                "payrolls = " + payrolls + ", " +
                "leaves = " + leaves + ", " +
                "timesheets = " + timesheets + ")";
    }
}