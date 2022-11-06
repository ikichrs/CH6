package com.binar.challenge4.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Table(name = "Studio")
public class StudioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Integer studioid;
    @Column(name = "studio_status")
    private Boolean studiostatus;
}
