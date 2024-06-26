package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.entity.Theater;
import com.booking_ticket.backend.repository.TheaterRepository;
import com.booking_ticket.backend.service.TheaterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public List<Theater> findAllTheater() {
        return theaterRepository.findAll();
    }

    @Override
    public boolean existsTheaterId(Long id) {
        return theaterRepository.existsById(id);
    }

    @Override
    public Optional<Theater> findById(Long id) {
        return theaterRepository.findById(id);
    }


    @Override
    public Theater save(Theater theater) {
        return theaterRepository.save(theater);
    }


}
