package com.booking_ticket.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "theater")
public class Theater extends BaseEntity {
    private String province;
    private String theater_name;
    private int number_of_screen;
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Movie> movies;

    public Theater(String province, String theater_name, int number_of_screen) {
        this.province = province;
        this.theater_name = theater_name;
        this.number_of_screen = number_of_screen;
    }
}
