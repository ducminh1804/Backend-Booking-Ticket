package com.booking_ticket.backend;

import com.booking_ticket.backend.entity.Role;
import com.booking_ticket.backend.entity.User;
import com.booking_ticket.backend.repository.RoleRepository;
import com.booking_ticket.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
@Transactional
@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        if (!userRepository.existsByUsername("admin")) {

            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("123"));

            // Assign default role "USER"
            Role defaultRole = roleRepository.findByName("ADMIN")
                    .orElseThrow(() -> new RuntimeException("Default role not found"));

            user.setRole(Collections.singletonList(defaultRole));
            userRepository.save(user);
        }
    }
}
