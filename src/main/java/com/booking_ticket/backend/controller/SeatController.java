package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.dto.RoomDto;
import com.booking_ticket.backend.dto.SeatCreateDto;
import com.booking_ticket.backend.dto.SeatDto;
import com.booking_ticket.backend.dto.SeatReturnDto;
import com.booking_ticket.backend.service.RoomService;
import com.booking_ticket.backend.service.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SeatController {
    @Autowired
    SeatService seatService;
    @Autowired
    RoomService roomService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/room/{roomId}/seats")
    public ResponseEntity<List<SeatDto>> getAllSeats(@PathVariable(value = "roomId") Long roomId) {
        if (!roomService.existsRoomId(roomId)) {
            List<SeatDto> seatDtos = null;
            return new ResponseEntity<List<SeatDto>>(seatDtos, HttpStatus.NOT_FOUND);
        }
        List<SeatDto> seatDtos = seatService.getAllSeatsByRoomId(roomId)
                .stream()
                .map(seat -> modelMapper.map(seat, SeatDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(seatDtos, HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<?> createSeat(@RequestBody SeatCreateDto seatCreateDto) {
        List<RoomDto> roomsIsValid = roomService.findRoomIsValid();
        List<Long> idRooms = roomsIsValid.stream().map(cur -> cur.getId()).collect(Collectors.toList());
        seatCreateDto.setRoom_id(idRooms.get(0));
        seatService.createSeat(seatCreateDto);
        return new ResponseEntity<>(seatCreateDto, HttpStatus.OK);
    }

//    @GetMapping("/seats")
//    public ResponseEntity<List<SeatReturnDto>> findAll() {
//        List<SeatReturnDto> seats = seatService.findAll()
//                .stream()
//                .map(cur -> modelMapper.map(cur, SeatReturnDto.class))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(seats);
//    }

    @GetMapping("/seats")
    public ResponseEntity<List<SeatReturnDto>> getAllSeats() {
        List<SeatReturnDto> seatReturnDtos = seatService.getAllSeats()
                .stream()
                .map(cur -> modelMapper.map(cur, SeatReturnDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(seatReturnDtos, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<List<String>> updateSeat(@RequestBody List<String> seat_names) {
        seatService.updateSeat(seat_names);
        return ResponseEntity.ok(seat_names);
    }
}
