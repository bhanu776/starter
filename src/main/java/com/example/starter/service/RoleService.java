
package com.example.starter.service;



import java.util.List;

import com.example.starter.domain.Role;

public interface RoleService {
    Role addRole(Role role);
    List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole(Long id);
    Role createOrGetRoleUser();
}
