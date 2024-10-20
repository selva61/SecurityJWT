package com.selva.securityjwt.controller;

import com.selva.securityjwt.DTO.LeaveDTO;
import com.selva.securityjwt.model.Leave;
import com.selva.securityjwt.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<LeaveDTO> getLeave(@PathVariable Long id) {
        return leaveService.getLeave(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LeaveDTO> createLeave(@RequestBody Leave leave) {
        LeaveDTO savedLeave = leaveService.saveLeave(leave);
        return ResponseEntity.ok(savedLeave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
        return ResponseEntity.ok().build();
    }
}
