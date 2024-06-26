package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

public interface TheaterScreeningDto {

    String getTheater_name();

    Time getStart_at();

}
