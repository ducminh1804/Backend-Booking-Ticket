package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.RoomDto;
import com.booking_ticket.backend.dto.SeatCreateDto;
import com.booking_ticket.backend.repository.RoomRepository;
import com.booking_ticket.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Override
    public boolean existsRoomId(Long id) {
        return roomRepository.existsById(id);
    }

    @Override
    public List<RoomDto> findRoomIsValid() {
        return roomRepository.findRoomIsValid();
    }


}
