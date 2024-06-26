package com.booking_ticket.backend.dto;

import lombok.Data;

@Data
public class MovieDto {
    private Long id;
    private String category;
    private String country;
    private Integer duration;
    private String format;
    private String manager;
    private String movie_name;
    private String performers;
    private String premiere;
    private String recommend;
    private String subtitle;
    private String urlImg;
}
