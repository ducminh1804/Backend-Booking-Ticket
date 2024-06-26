package com.booking_ticket.backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "room")
public class Room extends BaseEntity {
    private String room_name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    List<Seat> seats;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    List<Ticket>tickets;
}
