package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.TheaterScreeningDto;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.repository.ScreeningRepository;
import com.booking_ticket.backend.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    ScreeningRepository screeningRepository;
    @Override
    public List<Screening> getScreeningByMovieId(Long id) {
        return screeningRepository.getScreeningByMovieId(id);
    }


    @Override
    public List<TheaterScreeningDto> getTheaterByMovieIDAndScreeningId(Long movie_id, Long screening_id) {
        return screeningRepository.getTheaterByMovieIDAndScreeningId(movie_id,screening_id);
    }
}
