package com.selva.securityjwt.service;

import com.selva.securityjwt.DTO.RoleDTO;
import com.selva.securityjwt.mapper.DTOMapper;
import com.selva.securityjwt.model.Role;
import com.selva.securityjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return DTOMapper.toRoleDTOs(roles);
    }

    public Optional<RoleDTO> getRole(Long id) {
        Optional<Role> result = roleRepository.findById(id);
        return result.map(DTOMapper::toDTO);
    }

    public RoleDTO saveRole(Role role) {
        Role savedRole = roleRepository.save(role);
        return DTOMapper.toDTO(savedRole);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
