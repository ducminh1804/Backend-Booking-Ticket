package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TheaterScheduleDto {
    private Long theaterId;
    private String theaterName;
    private List<ScheduleDto> schedules;
}