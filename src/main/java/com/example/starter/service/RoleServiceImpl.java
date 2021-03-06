package com.example.starter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starter.domain.Role;
import com.example.starter.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        role.setId(null);
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role createOrGetRoleUser() {
        Role role = roleRepository.findOneByName("USER");
        if (role == null) {
            Role userRole = new Role();
            userRole.setName("USER");
            role = roleRepository.save(userRole);
        }
        return role;
    }
}
