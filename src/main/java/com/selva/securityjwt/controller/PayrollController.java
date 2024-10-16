package com.selva.securityjwt.controller;

import com.selva.securityjwt.model.Payroll;
import com.selva.securityjwt.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public Payroll getPayroll(@PathVariable Long id) {
        return payrollService.getPayroll(id);
    }

    @PostMapping
    public Payroll createPayroll(@RequestBody Payroll payroll) {
        return payrollService.savePayroll(payroll);
    }

    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
    }
}
