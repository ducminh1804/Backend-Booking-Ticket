package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.dto.CalendarScheduleDto;
import com.booking_ticket.backend.entity.CalendarSchedule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CalendarScheduleController {
    @GetMapping("/schedule")
    public ResponseEntity<?> getSchedule() {
        List<CalendarScheduleDto> list = CalendarSchedule.schedule();
        return ResponseEntity.ok(list);
    }
}
