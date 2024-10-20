package com.selva.securityjwt.controller;

import com.selva.securityjwt.DTO.PayrollDTO;
import com.selva.securityjwt.model.Payroll;
import com.selva.securityjwt.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @GetMapping
    public List<PayrollDTO> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> getPayroll(@PathVariable Long id) {
        Optional<PayrollDTO> payroll = payrollService.getPayroll(id);
        return payroll.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PayrollDTO> createPayroll(@RequestBody Payroll payroll) {
        PayrollDTO savedPayroll = payrollService.savePayroll(payroll);
        return ResponseEntity.ok(savedPayroll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.ok().build();
    }
}
