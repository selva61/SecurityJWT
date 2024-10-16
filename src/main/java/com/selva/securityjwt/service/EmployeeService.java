package com.selva.securityjwt.service;

import com.selva.securityjwt.model.Employee;
import com.selva.securityjwt.model.Leave;
import com.selva.securityjwt.model.Payroll;
import com.selva.securityjwt.repository.EmployeeRepository;
import com.selva.securityjwt.repository.LeaveRepository;
import com.selva.securityjwt.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        // Save the employee first to ensure it is managed by the session
        Employee savedEmployee = employeeRepository.save(employee);

        for (Payroll payroll : employee.getPayrolls()) {
            payroll.setEmployee(savedEmployee);
            payrollRepository.save(payroll);
        }
        for (Leave leave : employee.getLeaves()) {
            leave.setEmployee(savedEmployee);
            leaveRepository.save(leave);
        }
        return savedEmployee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
