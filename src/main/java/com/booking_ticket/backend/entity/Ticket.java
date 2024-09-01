package com.booking_ticket.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket extends SubEntity {

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Seat> seats;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;


    @ManyToOne
    @JoinColumn(name = "combo_id")
    @JsonIgnore
    private Combo combo;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    @JsonIgnore
    private Screening screening;

    private int ngay;
    private String start_at;
    private int thang;
    private String combo_name;
    private String seat;
    private Float total_price;
}
