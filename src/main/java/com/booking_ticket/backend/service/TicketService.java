package com.booking_ticket.backend.service;


import com.booking_ticket.backend.dto.TicketCreateDto;
import com.booking_ticket.backend.dto.TicketDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketService {
    List<TicketDto> getTicketByTicketId(Long id);
    List<TicketDto> getTicketByUserId(Long id);

    void createTicket(TicketCreateDto ticketCreateDto);
}
