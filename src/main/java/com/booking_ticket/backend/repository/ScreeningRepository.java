package com.booking_ticket.backend.repository;

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

    @Query(value = "select t.theater_name,s.start_at from movie m " +
            "join screening s on m.id = s.movie_id " +
            "join theater t on t.id =  m.theater_id " +
            "where m.id = :movie_id and s.id =:screening_id",
            nativeQuery = true)
    List<TheaterScreeningDto> getTheaterByMovieIDAndScreeningId(@Param("movie_id") Long movie_id,
                                                                @Param("screening_id") Long screening_id);
}
