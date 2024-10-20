package com.selva.securityjwt.mapper;

import com.selva.securityjwt.DTO.*;
import com.selva.securityjwt.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class DTOMapper {
    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getTaskDescription(), task.getProject().getId(), task.getStartDate(), task.getDueDate());
    }

    public static List<TaskDTO> toTaskDTOs(List<Task> tasks) {
        return tasks.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static ProjectDTO toDTO(Project project) {
        return new ProjectDTO(project.getId(), project.getProjectName(),project.getClient());
    }

    public static List<ProjectDTO> toProjectDTOs(List<Project> projects) {
        return projects.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getAddress(), employee.getCity(), employee.getState(), employee.getCountry(), employee.getZip(), employee.getDepartment(), employee.getDesignation(), employee.getStatus(), DTOMapper.toRoleDTOs(employee.getRoles()), DTOMapper.toPayrollDTOs(employee.getPayrolls()), DTOMapper.toLeaveDTOs(employee.getLeaves()), DTOMapper.toTimesheetDTOs(employee.getTimesheets()));
    }

    public static TimesheetDTO toDTO(Timesheet timesheet) {
        return new TimesheetDTO(timesheet.getId(), timesheet.getDate(), timesheet.getHoursWorked());
    }

    public static List<TimesheetDTO> toTimesheetDTOs(List<Timesheet> timesheets) {
        return timesheets.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static LeaveDTO toDTO(Leave leave) {
        return new LeaveDTO(leave.getId(), leave.getStartDate(), leave.getEndDate(), leave.getType(), leave.getBal_annual_leave(), leave.getBal_sick_leave(), leave.getBal_child_care_leave());
    }

    public static List<LeaveDTO> toLeaveDTOs(List<Leave> leaves) {
        return leaves.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static PayrollDTO toDTO(Payroll payroll) {
        return new PayrollDTO(payroll.getId(), payroll.getSalary(),payroll.getPayDate());
    }

    public static List<PayrollDTO> toPayrollDTOs(List<Payroll> payrolls) {
        return payrolls.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static RoleDTO toDTO(Role role) {
        return new RoleDTO(role.getId(), role.getName());
    }

    public static List<RoleDTO> toRoleDTOs(List<Role> roles) {
        return roles.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees) {
        return employees.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

    public static ClientDTO toDTO(Client client) {
    return new ClientDTO(client.getId(), client.getClientName(), client.getContactEmail());
    }

    public static List<ClientDTO> toClientDTOs(List<Client> clients) {
        return clients.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }

}
