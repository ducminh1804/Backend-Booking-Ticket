package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.dto.RoomDto;
import com.booking_ticket.backend.entity.Room;
import com.booking_ticket.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/roomvalid")
    public ResponseEntity<List<RoomDto>> findRoomIsValid() {
        List<RoomDto> rooms = roomService.findRoomIsValid();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
