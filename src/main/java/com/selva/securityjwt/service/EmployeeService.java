package com.selva.securityjwt.service;

import com.selva.securityjwt.DTO.EmployeeDTO;
import com.selva.securityjwt.DTO.ProjectDTO;
import com.selva.securityjwt.mapper.DTOMapper;
import com.selva.securityjwt.model.Employee;
import com.selva.securityjwt.model.Leave;
import com.selva.securityjwt.model.Payroll;
import com.selva.securityjwt.model.Project;
import com.selva.securityjwt.repository.EmployeeRepository;
import com.selva.securityjwt.repository.LeaveRepository;
import com.selva.securityjwt.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return DTOMapper.toEmployeeDTOs(employees);
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(DTOMapper::toDTO);
    }

    public EmployeeDTO saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return DTOMapper.toDTO(savedEmployee);
    }

    @Transactional
    public EmployeeDTO createEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        for (Payroll payroll : employee.getPayrolls()) {
            payroll.setEmployee(savedEmployee);
            payrollRepository.save(payroll);
        }
        return DTOMapper.toDTO(savedEmployee);
    }

    @Transactional
    public Employee createEmployee1(Employee employee) {
        // Save the employee first to ensure it is managed by the session
        Employee savedEmployee = employeeRepository.save(employee);

        for (Payroll payroll : employee.getPayrolls()) {
            payroll.setEmployee(savedEmployee);
            payrollRepository.save(payroll);
        }
        /*
        for (Leave leave : employee.getLeaves()) {
            leave.setEmployee(savedEmployee);
            leaveRepository.save(leave);
        }*/
        return savedEmployee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
