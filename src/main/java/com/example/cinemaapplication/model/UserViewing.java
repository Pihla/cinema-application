package com.example.cinemaapplication.model;

import jakarta.persistence.*;

@Entity
public class UserViewing {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    MovieShowtime movieShowtime;

    public UserViewing(MovieShowtime movieShowtime) {
        this.movieShowtime = movieShowtime;
    }

    protected UserViewing() {

    }
}
