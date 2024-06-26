package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.TicketCreateDto;
import com.booking_ticket.backend.dto.TicketDto;
import com.booking_ticket.backend.repository.TicketRepository;
import com.booking_ticket.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<TicketDto> getTicketByTicketId(Long id) {
        return ticketRepository.getTicketByTicketId(id);
    }

    @Override
    public List<TicketDto> getTicketByUserId(Long id) {
        return ticketRepository.getTicketByUserId(id);
    }

    @Override
    public void createTicket(TicketCreateDto ticketCreateDto) {
        ticketRepository.createTicket(ticketCreateDto);
    }

}
