package com.selva.securityjwt.service;

import com.selva.securityjwt.DTO.PayrollDTO;
import com.selva.securityjwt.mapper.DTOMapper;
import com.selva.securityjwt.model.Payroll;
import com.selva.securityjwt.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    public List<PayrollDTO> getAllPayrolls() {
        List<Payroll> payrolls = payrollRepository.findAll();
        return DTOMapper.toPayrollDTOs(payrolls);
    }

    public Optional<PayrollDTO> getPayroll(Long id) {
        Optional<Payroll> result = payrollRepository.findById(id);
        return result.map(DTOMapper::toDTO);
    }

    public PayrollDTO savePayroll(Payroll payroll) {
        Payroll savedPayroll = payrollRepository.save(payroll);
        return DTOMapper.toDTO(savedPayroll);
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
