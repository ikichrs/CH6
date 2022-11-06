package com.binar.challenge4.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Table(name = "Seats")
public class SeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_number")
    private String seatnumber;
    @Column(name = "seat_status")
    private Boolean seatstatus;
}
