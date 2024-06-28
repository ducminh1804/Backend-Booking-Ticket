package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.TheaterScheduleDto;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.repository.ScreeningRepository;
import com.booking_ticket.backend.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    ScreeningRepository screeningRepository;
    @Override
    public List<Screening> getScreeningByMovieId(Long id) {
        return screeningRepository.getScreeningByMovieId(id);
    }

    @Override
    public Map<String, Map<String, List<Map<String, Object>>>> getTheaterSchedules(Long movieId, Long screeningId) {
        List<Object[]> results = screeningRepository.getTheaterByMovieIDAndScreeningId(movieId, screeningId);

        Map<String, Map<String, List<Map<String, Object>>>> formattedResult = new LinkedHashMap<>();

        for (Object[] result : results) {
            Long theaterId = (Long) result[0];
            String theaterName = (String) result[1];
            screeningId = (Long) result[2];
            Time startAt = (Time) result[3];

            String theaterKey = theaterName + "_" + theaterId;

            formattedResult.computeIfAbsent(theaterKey, k -> new LinkedHashMap<>())
                    .computeIfAbsent("schedules", k -> new ArrayList<>())
                    .add(Map.of("id", screeningId, "start_at", startAt.toString()));
        }

        return formattedResult;
    }


}
