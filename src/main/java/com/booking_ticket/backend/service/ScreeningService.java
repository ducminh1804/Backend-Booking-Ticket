package com.booking_ticket.backend.service;

import com.booking_ticket.backend.dto.TheaterScheduleDto;
import com.booking_ticket.backend.entity.Screening;

import java.util.List;
import java.util.Map;

public interface ScreeningService {
    List<Screening> getScreeningByMovieId(Long id);

    Map<String, Map<String, List<Map<String, Object>>>> getTheaterSchedules(Long movieId, Long screeningId);


}