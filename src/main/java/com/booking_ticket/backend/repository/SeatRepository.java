package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.dto.SeatCreateDto;
import com.booking_ticket.backend.dto.SeatReturnDto;
import com.booking_ticket.backend.entity.Seat;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByRoomId(Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO seat (seat_name, `row`, price, state, room_id, screening_id, user_id, movie_id) " +
            "VALUES (:#{#dto.seat_name}, :#{#dto.row}, :#{#dto.price}, :#{#dto.state}, " +
            ":#{#dto.room_id}, :#{#dto.screening_id}, :#{#dto.user_id}, :#{#dto.movie_id})",
            nativeQuery = true)
    void createSeat(@Param("dto") SeatCreateDto dto);

    List<Seat> findAll();

    @Query("SELECT new com.booking_ticket.backend.dto.SeatReturnDto(s.id, s.seat_name, s.state) FROM Seat s")
    List<SeatReturnDto> getAllSeats();

}
