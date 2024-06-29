package com.booking_ticket.backend.entity;

import com.booking_ticket.backend.dto.CalendarScheduleDto;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;

import static java.util.Calendar.*;

public class CalendarSchedule {
    static List<CalendarScheduleDto> list = new ArrayList<>();
    private CalendarScheduleDto c;

    public static List<CalendarScheduleDto> schedule() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate a = LocalDate.now();
        for (int i = 1; i < 20; i++) {
            String b = "";
            int cur_b = a.getDayOfWeek().getValue() + 1;
            if (cur_b == 8) {
                b = "CN";
            } else {
                b = "Thứ " + cur_b;
            }
            list.add(new CalendarScheduleDto(String.valueOf(dtf.format(a)), b));
            a = a.plusDays(1);
        }
        return list;
    }

    public static void main(String[] args) {
        CalendarSchedule calendarSchedule = new CalendarSchedule();
        List<CalendarScheduleDto> list = CalendarSchedule.schedule();
        System.out.println(list);
    }
}