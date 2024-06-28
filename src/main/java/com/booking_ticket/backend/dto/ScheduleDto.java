package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;

@Data
@AllArgsConstructor
public class ScheduleDto {
    private Long screeningId;
    private Time startAt;
}