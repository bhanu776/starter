package com.example.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.starter.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);
    User findOneByActivationHash(String activationHash);
}
