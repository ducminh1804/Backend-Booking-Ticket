package com.booking_ticket.backend.service;

import com.booking_ticket.backend.entity.Theater;

import java.util.List;
import java.util.Optional;

public interface TheaterService {
    List<Theater> findAllTheater();
    boolean existsTheaterId(Long id);
    Optional<Theater> findById(Long id);
    Theater save(Theater theater);
}
