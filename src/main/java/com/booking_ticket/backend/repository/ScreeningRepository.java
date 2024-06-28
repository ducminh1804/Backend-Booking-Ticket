package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.dto.TheaterScheduleDto;
import com.booking_ticket.backend.dto.TheaterScreeningDto;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.entity.Theater;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query("select s from Screening s where s.movie.id = :id")
    List<Screening> getScreeningByMovieId(Long id);


    @Query(value = "SELECT t.id AS theater_id, t.theater_name, s.id AS screening_id, s.start_at " +
            "FROM theater t " +
            "JOIN theater_movie tm ON t.id = tm.theater_id " +
            "JOIN movie m ON m.id = tm.movie_id " +
            "JOIN screening s ON s.movie_id = m.id " +
            "WHERE m.id = :movie_id AND s.id = :screening_id",
            nativeQuery = true)
    List<Object[]> getTheaterByMovieIDAndScreeningId(@Param("movie_id") Long movie_id,
                                                     @Param("screening_id") Long screening_id);

}
