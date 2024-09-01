package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.SeatCreateDto;
import com.booking_ticket.backend.dto.SeatReturnDto;
import com.booking_ticket.backend.entity.Room;
import com.booking_ticket.backend.entity.Seat;
import com.booking_ticket.backend.repository.SeatRepository;
import com.booking_ticket.backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Optional<Room> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Seat> getAllSeatsByRoomId(Long id) {
        return seatRepository.findAllByRoomId(id);
    }

    @Override
    public Seat getSeat(Long id, String seat_name) {
        List<Seat> seats = getAllSeatsByRoomId(id)
                .stream()
                .filter(item -> item.getSeat_name().equals(seat_name))
                .collect(Collectors.toList());
        return seats.get(0);
    }

    @Override
    public boolean existsRoomId(Long id) {
        return seatRepository.existsById(id);
    }

    @Override
    public void createSeat(SeatCreateDto seatCreateDto) {
        seatRepository.createSeat(seatCreateDto);
    }

    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    @Override
    public List<SeatReturnDto> getAllSeats() {
        return seatRepository.getAllSeats();
    }

    @Override
    public void updateSeat(List<String> seat_name) {
         seatRepository.updateSeats(seat_name);
    }


}
