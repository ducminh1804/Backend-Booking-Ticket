package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.Exception.NotFoundException;
import com.booking_ticket.backend.entity.Movie;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.entity.Theater;
import com.booking_ticket.backend.entity.UsernameCurrent;
import com.booking_ticket.backend.service.CloudinaryService;
import com.booking_ticket.backend.service.MovieService;
import com.booking_ticket.backend.service.TheaterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieShowtimeController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MovieService movieService;
    @Autowired
    TheaterService theaterService;
    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping(path = "/theaters/{theaterId}/movies/showtimes", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Movie> createMovies(@PathVariable(value = "theaterId") Long theaterId,
                                              @RequestPart("movie") Movie movie,
                                              @RequestPart("screening") List<Screening> screening,
                                              @RequestPart("image") MultipartFile file) throws IOException {
        Theater re = theaterService.findById(theaterId).orElseThrow(() -> new NotFoundException("Not found theater_id"));

        Movie movie1 = new Movie();
        BeanUtils.copyProperties(movie, movie1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        movie1.setTheater(re);
        movie1.setCreate_at(now);
        movie1.setCreate_by(new UsernameCurrent().usernameCurrent);
        movie1.setUrlImg(this.cloudinaryService.upLoadFile(file));
        movieService.createMovieSreenings(movie1, screening);
        return new ResponseEntity<>(movie1, HttpStatus.OK);
    }
}
