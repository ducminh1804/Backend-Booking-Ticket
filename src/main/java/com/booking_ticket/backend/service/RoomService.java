package com.booking_ticket.backend.service;

import com.booking_ticket.backend.dto.RoomDto;
import com.booking_ticket.backend.dto.SeatCreateDto;

import java.util.List;

public interface RoomService {
    boolean existsRoomId(Long id);

    List<RoomDto> findRoomIsValid();

}
