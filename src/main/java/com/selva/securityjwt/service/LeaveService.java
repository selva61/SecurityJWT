package com.selva.securityjwt.service;

import com.selva.securityjwt.DTO.LeaveDTO;
import com.selva.securityjwt.mapper.DTOMapper;
import com.selva.securityjwt.model.Leave;
import com.selva.securityjwt.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public List<LeaveDTO> getAllLeaves() {
        List<Leave> leaves = leaveRepository.findAll();
        return DTOMapper.toLeaveDTOs(leaves);
    }

    public Optional<LeaveDTO> getLeave(Long id) {
        Optional<Leave> result = leaveRepository.findById(id);
        return result.map(DTOMapper::toDTO);
    }

    public LeaveDTO saveLeave(Leave leave) {
        Leave savedLeave = leaveRepository.save(leave);
        return DTOMapper.toDTO(savedLeave);
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}
