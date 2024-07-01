package com.booking_ticket.backend.service;

import com.booking_ticket.backend.dto.SeatCreateDto;
import com.booking_ticket.backend.dto.SeatReturnDto;
import com.booking_ticket.backend.entity.Room;
import com.booking_ticket.backend.entity.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    Optional<Room> findById(Long id);

    List<Seat> getAllSeatsByRoomId(Long id);

    Seat getSeat(Long id, String seat_name);

    boolean existsRoomId(Long id);

    void createSeat(SeatCreateDto seatCreateDto);

    List<Seat> findAll();

    List<SeatReturnDto> getAllSeats();
}
