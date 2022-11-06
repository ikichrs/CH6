package com.binar.challenge4.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//class sebagai entity
@Entity
@Getter
@Setter

//table dengan nama Film
@Table(name = "FilmTable")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @Column(name = "film_title")
    private String filmtitle;

    @Column(name = "durasi")
    private String durasi;

    @Column(name = "status")
    private Boolean status;
}
