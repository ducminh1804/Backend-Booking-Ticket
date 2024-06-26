package com.booking_ticket.backend.dto;

import lombok.Data;

@Data
public class SeatDto {
    private Long id;
    private String seat_name;
    private String row;
    private Double price;
    private Integer state;
}
