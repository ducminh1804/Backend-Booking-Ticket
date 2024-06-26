package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class SeatCreateDto {
    private String seat_name;
    private String row;
    private Double price;
    private Integer state;
    private Long room_id;
    private Long screening_id;
    private Long user_id;
    private Long movie_id;
}
