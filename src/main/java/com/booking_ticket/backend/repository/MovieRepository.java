package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTheaterId(Long id);
    List<Movie> findAll();
    Movie getById(Long id);
}
