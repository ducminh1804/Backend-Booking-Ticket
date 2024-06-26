package com.booking_ticket.backend.entity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsernameCurrent {
    public static String usernameCurrent;

    public UsernameCurrent() {
        usernameCurrent = SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
