package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.dto.MovieDto;
import com.booking_ticket.backend.dto.MovieReturnByScreening;
import com.booking_ticket.backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTheatersId(Long id);
    List<Movie> findAll();
    Movie getById(Long id);


    @Query(value = "SELECT m.movie_name, m.category, m.url_img, s.start_at " +
            "FROM screening s " +
            "JOIN movie m ON m.id = s.movie_id " +
            "WHERE s.ngay = :ngay AND s.thang = :thang", nativeQuery = true)
    List<MovieReturnByScreening> findMoviesByDate(@Param("ngay") int ngay, @Param("thang") int thang);

}
