package com.booking_ticket.backend.service;

import com.booking_ticket.backend.dto.RegisterDto;
import com.booking_ticket.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface UserService {
    void save(RegisterDto registerDto);
}
