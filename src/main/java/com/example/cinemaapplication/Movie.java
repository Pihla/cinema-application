package com.example.cinemaapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//https://spring.io/guides/gs/accessing-data-jpa
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    protected Movie() {

    }

    public String toString() {
        return name;
    }
}
