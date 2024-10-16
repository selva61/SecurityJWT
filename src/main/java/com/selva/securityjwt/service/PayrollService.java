package com.selva.securityjwt.service;

import com.selva.securityjwt.model.Payroll;
import com.selva.securityjwt.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getPayroll(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    public Payroll savePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
