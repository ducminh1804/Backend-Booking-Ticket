package com.booking_ticket.backend.service;

import com.booking_ticket.backend.dto.TheaterScreeningDto;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.entity.Theater;

import java.util.List;

public interface ScreeningService {
    List<Screening> getScreeningByMovieId(Long id);

    List<TheaterScreeningDto> getTheaterByMovieIDAndScreeningId(Long movie_id, Long screening_id);
}
