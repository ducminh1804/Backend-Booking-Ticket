package com.booking_ticket.backend.service.Impl;

import com.booking_ticket.backend.dto.MovieReturnByScreening;
import com.booking_ticket.backend.entity.Movie;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.repository.MovieRepository;
import com.booking_ticket.backend.repository.ScreeningRepository;
import com.booking_ticket.backend.service.MovieService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(rollbackOn = {Exception.class, Throwable.class})
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Movie> findByTheaterId(Long id) {
        return movieRepository.findByTheatersId(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getById(Long id) {
        return movieRepository.getById(id);
    }


    @Override
    public Movie createMovieSreenings(Movie movie, List<Screening> screenings) {
        Movie movie1 = new Movie();
        BeanUtils.copyProperties(movie, movie1);

        movie.setScreenings(screenings);

        for (Screening screening : screenings) {
            screening.setMovie(movie);
        }
//        movie.setScreenings(screenings);
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieReturnByScreening> getMovieByDate(int ngay, int thang) {
        return movieRepository.findMoviesByDate(ngay,thang);
    }

    @Override
    public List<MovieReturnByScreening> findMoviesByDateMovieId(int ngay, int thang, Long id) {
        return movieRepository.findMoviesByDateMovieId(ngay,thang,id);
    }


}
