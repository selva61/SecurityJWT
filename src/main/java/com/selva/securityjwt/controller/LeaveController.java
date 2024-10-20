package com.selva.securityjwt.controller;

import com.selva.securityjwt.DTO.LeaveDTO;
import com.selva.securityjwt.model.Leave;
import com.selva.securityjwt.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public List<LeaveDTO> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leave getLeave(@PathVariable Long id) {
        return leaveService.getLeave(id);
    }

    @PostMapping
    public Leave createLeave(@RequestBody Leave leave) {
        return leaveService.saveLeave(leave);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
    }
}
