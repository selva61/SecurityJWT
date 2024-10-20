package com.selva.securityjwt.controller;

import com.selva.securityjwt.DTO.RoleDTO;
import com.selva.securityjwt.model.Role;
import com.selva.securityjwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRole(@PathVariable Long id) {
        Optional<RoleDTO> role = roleService.getRole(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody Role role) {
        RoleDTO savedRole = roleService.saveRole(role);
        return ResponseEntity.ok(savedRole);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
