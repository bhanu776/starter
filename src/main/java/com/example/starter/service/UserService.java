package com.example.starter.service;


import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.starter.domain.User;

public interface UserService extends UserDetailsService {
    Optional<User> getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    void activateEmail(String activationHash);
}
