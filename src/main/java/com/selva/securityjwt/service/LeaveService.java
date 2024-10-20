package com.selva.securityjwt.service;

import com.selva.securityjwt.DTO.LeaveDTO;
import com.selva.securityjwt.mapper.DTOMapper;
import com.selva.securityjwt.model.Leave;
import com.selva.securityjwt.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public List<LeaveDTO> getAllLeaves() {
        List<Leave> leaves = leaveRepository.findAll();
        return DTOMapper.toLeaveDTOs(leaves);
    }

    public Leave getLeave(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}
