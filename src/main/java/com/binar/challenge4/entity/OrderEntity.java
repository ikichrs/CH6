package com.binar.challenge4.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter

@Table(name = "Order")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="order_id")
    private Long order_id;

    @Column(name ="film_id")
    private Long film_id;
//    @ManyToOne
//    @JoinColumn(name="film_id", insertable = false, updatable = false)
//    private FilmEntity filmEntity;
//
//    @Column(name ="film_title")
//    private Long film_title;
//    @ManyToOne
//    @JoinColumn(name="film_title", insertable = false, updatable = false)
//    private FilmEntity filmEntity1;
//
//    @Column(name ="user_id")
//    private Integer user_id;
//    @ManyToOne
//    @JoinColumn(name="user_id", insertable = false,updatable = false)
//    private UserEntity userEntity;
//
//    @Column(name ="seat_number")
//    private String seats;
//    @ManyToOne
//    @JoinColumn(name="seat_number", insertable = false, updatable = false)
//    private SeatsEntity seatsEntity;
//
//    @Column(name="studio_id")
//    private Float studio_id;
//    @ManyToOne
//    @JoinColumn(name="studio_id", insertable = false, updatable = false)
//    private StudioEntity studioEntity;

}
