package com.binar.challenge4.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter

@Table(name = "Schedules")
public class SchedulesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedules_id")
    private String schedules_id;

    @Column(name = "film_id")
    private Long film_id;
    @ManyToOne
    @JoinColumn(name="film_id", insertable = false, updatable = false)
    private FilmEntity filmEntity;

    @Column(name = "date")
    private Date date;

    @Column(name = "start")
    private Time start;

    @Column(name = "end")
    private Time end;

    @Column(name = "price")
    private Float price;
}
