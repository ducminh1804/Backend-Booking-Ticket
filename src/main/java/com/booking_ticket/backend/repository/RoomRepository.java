package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.dto.RoomDto;
import com.booking_ticket.backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "select r.id, r.room_name from room r " +
            "join seat s on r.id = s.room_id " +
            "where s.state = 0 " +
            "group by r.id,r.room_name " +
            "having count(*) <=30",
            nativeQuery = true)
    List<RoomDto> findRoomIsValid();
}
