package com.example.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.starter.domain.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findOneByName(String name);
}
