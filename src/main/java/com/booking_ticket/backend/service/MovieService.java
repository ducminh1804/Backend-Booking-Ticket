package com.booking_ticket.backend.service;

import com.booking_ticket.backend.entity.Movie;
import com.booking_ticket.backend.entity.Screening;

import java.util.List;

public interface MovieService {
    List<Movie> findByTheaterId(Long id);

    Movie saveMovie(Movie movie);

    List<Movie> findAll();

    Movie getById(Long id);


    Movie createMovieSreenings(Movie movie, List<Screening> screening);
}
