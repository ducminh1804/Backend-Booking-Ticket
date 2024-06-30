package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieMapDto {
    private String movie_id;
    private List<MovieMapSubDto> movieMapSubDto;
}
