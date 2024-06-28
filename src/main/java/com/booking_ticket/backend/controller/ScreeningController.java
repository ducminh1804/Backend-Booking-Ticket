package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.dto.ScreeningDto;
import com.booking_ticket.backend.dto.SeatCreateDto;
import com.booking_ticket.backend.dto.TheaterScheduleDto;
import com.booking_ticket.backend.dto.TheaterScreeningDto;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.entity.Theater;
import com.booking_ticket.backend.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ScreeningController {
    @Autowired
    ScreeningService screeningService;

    @GetMapping("/movie/{movie_id}/screening")
    public ResponseEntity<List<ScreeningDto>> getScreeningByMovieId(@PathVariable(value = "movie_id") Long movie_id) {
        List<Screening> screenings = screeningService.getScreeningByMovieId(movie_id);
        Calendar c = Calendar.getInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        List<ScreeningDto> screeningDtos =
                screenings
                        .stream()
                        .map(cur -> {
                            String s = String.valueOf(cur.getDay().getDayOfWeek());
                            return new ScreeningDto(cur.getId(), formatter.format(cur.getDay()), s);
                        })
                        .collect(Collectors.toList());
        return new ResponseEntity<>(screeningDtos, HttpStatus.OK);
    }

    //    @GetMapping("/movie/{movie_id}/screening/{screening_id}/theater")
//    public ResponseEntity<Map<String, List<TheaterScreeningDto>>> getTheaterByMovieIDAndScreeningId(@PathVariable(value = "movie_id") Long movie_id,
//                                                                                                    @PathVariable(value = "screening_id") Long screening_id) {
////        SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm:ss");
//        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");
//
//        List<TheaterScreeningDto> theaters = screeningService.getTheaterByMovieIDAndScreeningId(movie_id, screening_id);
//        theaters.stream().map(cur -> formatTime.format(cur.getStart_at())).collect(Collectors.toList());
//        if (theaters.size() == 0) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//
//
//        Map<String, List<TheaterScreeningDto>> map = theaters.stream()
//                .collect(
//                        Collectors.groupingBy(TheaterScreeningDto::getTheater_name));
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
    @GetMapping("movie/{movieId}/screenings/{screeningId}/theater")
    public ResponseEntity<?> getTheaterSchedules(@PathVariable Long movieId, @PathVariable Long screeningId) {
        Map<String, Map<String, List<Map<String, Object>>>> result = screeningService.getTheaterSchedules(movieId, screeningId);
        return ResponseEntity.ok(result);
    }

}
