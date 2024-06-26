package com.booking_ticket.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "combo")
public class Combo extends BaseEntity {
    private String name;
    private int amount;

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
