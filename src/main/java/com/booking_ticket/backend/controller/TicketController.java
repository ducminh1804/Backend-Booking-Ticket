package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.dto.RoomDto;
import com.booking_ticket.backend.dto.TicketCreateDto;
import com.booking_ticket.backend.dto.TicketDto;
import com.booking_ticket.backend.entity.Ticket;
import com.booking_ticket.backend.repository.TicketRepository;
import com.booking_ticket.backend.service.RoomService;
import com.booking_ticket.backend.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RoomService roomService;



    @GetMapping("/ticket/{ticket_id}")
    public ResponseEntity<List<TicketDto>> findByTicketId(@PathVariable(value = "ticket_id") Long ticket_id) {
        List<TicketDto> ticket = ticketService.getTicketByTicketId(ticket_id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/ticket/user/{user_id}")
    public ResponseEntity<List<TicketDto>> findByUserId(@PathVariable(value = "user_id") Long user_id) {
        List<TicketDto> ticket = ticketService.getTicketByUserId(user_id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/addTicket")
    public ResponseEntity<TicketCreateDto> createTicket(@RequestBody TicketCreateDto ticketCreateDto) {
        List<RoomDto> roomsIsValid = roomService.findRoomIsValid();
        List<Long> idRooms = roomsIsValid.stream().map(cur -> cur.getId()).collect(Collectors.toList());
//        ticketCreateDto.setRoom_id(idRooms.get(0));
        ticketCreateDto.setRoom_id(1l);

        ticketService.createTicket(ticketCreateDto);
        return new ResponseEntity<>(ticketCreateDto, HttpStatus.CREATED);
    }


    @PostMapping("/createticket")
    public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) {
        ticket.setCombo(null);
        Ticket re = ticketService.save(ticket);

        return ResponseEntity.ok(re);
    }

}