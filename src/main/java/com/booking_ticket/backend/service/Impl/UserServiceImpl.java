package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.RegisterDto;
import com.booking_ticket.backend.entity.Role;
import com.booking_ticket.backend.entity.User;
import com.booking_ticket.backend.repository.RoleRepository;
import com.booking_ticket.backend.repository.UserRepository;
import com.booking_ticket.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void save(RegisterDto registerDto) {
        // Create new user
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // Assign default role "USER"
        Role defaultRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        user.setRole(Collections.singletonList(defaultRole));
        userRepository.save(user);
    }

    @Override
    public String findIdByUsername(String username) {
        return null;
    }

//    @Override
//    public String findIdByUsername(String username) {
//        return userRepository.findIdByUsername(username);
//    }
}
