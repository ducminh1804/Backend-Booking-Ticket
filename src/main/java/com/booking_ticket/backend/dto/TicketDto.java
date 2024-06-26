package com.booking_ticket.backend.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Time;
import java.util.Date;
@JsonPropertyOrder({"theaterName", "username", "day", "startAt", "movieName", "roomName", "seatName","combo"})
public interface TicketDto {
    String getTheaterName();
    String getUsername();
    String getDay();
    String getStartAt();
    String getMovieName();
    String getRoomName();
    String getSeatName();
    String getCombo();

}
