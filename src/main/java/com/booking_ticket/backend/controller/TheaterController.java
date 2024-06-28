package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.Exception.NotFoundException;
import com.booking_ticket.backend.entity.Theater;
import com.booking_ticket.backend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getAllTheater() {
        List<Theater> theaters = theaterService.findAllTheater();
        return new ResponseEntity<>(theaters, HttpStatus.OK);
    }

    @GetMapping("theater/{theater_id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable(value = "theater_id") Long theater_id) {
        Theater theater = theaterService.findById(theater_id).orElseThrow(() -> new NotFoundException("Not found theater"));
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }
//    @PostMapping("/theaters")
//    public ResponseEntity<?> createTheater(@RequestBody Theater theater) {
//        Theater theater1 = new Theater(theater.getProvince(), theater.getTheater_name(), theater.getNumber_of_screen());
//        Theater theater2 = theaterService.save(theater1);
//        return new ResponseEntity<>(theater2, HttpStatus.CREATED);
//    }

}

