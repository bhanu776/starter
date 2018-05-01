package com.example.starter.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.starter.domain.Role;
import com.example.starter.domain.User;
import com.example.starter.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

  
    @Override
    public Optional<User> getUserById(Long id) {
        return  userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void activateEmail(String activationHash) {
        User user = userRepository.findOneByActivationHash(activationHash);
        if (user == null) {
        }

        user.setActivated(true);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findOneByEmail(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException("USER_NOT_FOUND");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : foundUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(username, foundUser.getPassword(),
                true, true, true, foundUser.isActivated(),
                grantedAuthorities);
    }

}
