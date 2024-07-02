package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.dto.TicketCreateDto;
import com.booking_ticket.backend.dto.TicketDto;
import com.booking_ticket.backend.entity.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public Ticket save(Ticket ticket);

    @Query(value = "select th.theater_name,u.username,  sc.day, sc.start_at,m.movie_name, r.room_name, s.seat_name,c.name " +
            "from ticket t " +
            "         join combo c on c.id = t.combo_id " +
            "         join user u on u.id = t.user_id " +
            "         join movie m on m.id = t.movie_id " +
            "         join theater th on th.id = m.theater_id " +
            "         join screening sc on sc.movie_id = m.id " +
            "         join room r on r.id = t.room_id " +
            "         join seat s on s.room_id = r.id " +
            "where t.id = :id", nativeQuery = true)
    List<TicketDto> getTicketByTicketId(@Param("id") Long id);


    @Query(value = "select th.theater_name,u.username,  sc.day, sc.start_at,m.movie_name, r.room_name, s.seat_name,c.name " +
            "from ticket t " +
            "         join combo c on c.id = t.combo_id " +
            "         join user u on u.id = t.user_id " +
            "         join movie m on m.id = t.movie_id " +
            "         join theater th on th.id = m.theater_id " +
            "         join screening sc on sc.movie_id = m.id " +
            "         join room r on r.id = t.room_id " +
            "         join seat s on s.room_id = r.id " +
            "where u.id = :id", nativeQuery = true)
    List<TicketDto> getTicketByUserId(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "insert into ticket( user_id,movie_id ,room_id,combo_id,screening_id,ngay,start_at,thang,combo_name,seat,total_price) " +
            "values (:#{#dto.user_id},:#{#dto.movie_id},:#{#dto.room_id},:#{#dto.combo_id},:#{#dto.screening_id},:#{#dto.ngay},:#{#dto.start_at},:#{#dto.thang},:#{#dto.combo_name},:#{#dto.seat},:#{#dto.total_price})",
            nativeQuery = true)
    void createTicket(@Param("dto") TicketCreateDto dto);
}
