package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TicketCreateDto {
    private Long user_id;
    private Long movie_id;
    private Long room_id;
    private Long combo_id;
    private Long screening_id;
}
