package com.booking_ticket.backend.entity;

import com.booking_ticket.backend.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie extends SubEntity {
    private String movie_name;
    private int duration;
    private String category;
    private String country;
    private String subtitle;
    private String recommend;
    private String manager;
    private String performers;
    private String premiere;
    private String format;
    private String urlImg;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Screening> screenings;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("movies") // Loại bỏ thuộc tính movies trong Theater để tránh vòng lặp khi serialize JSON
    private List<Theater> theaters;


}
