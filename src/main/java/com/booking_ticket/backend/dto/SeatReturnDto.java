package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatReturnDto {
    private Long id;

    private String seat_name;

    private int state;
}
