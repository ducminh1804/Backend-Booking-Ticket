package com.booking_ticket.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

public interface MovieReturnByScreening {

    public String getMovie_name();

    public String getCategory();

    public String getUrlImg();
    public Time getStart_at();
}
