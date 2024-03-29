package com.example.cinemaapplication.model;

import jakarta.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    private MovieGenre genre;
    private AgeLimit ageLimit;
    private int timeInMinutes;


    public Movie(String name, MovieGenre genre, AgeLimit ageLimit, int timeInMinutes) {
        this.name = name;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.timeInMinutes = timeInMinutes;
    }

    protected Movie() {

    }

    public String toString() {
        return name;
    }



    public enum AgeLimit {
        NO_LIMIT, NOT_RECOMMENDED_UNDER_6, NOT_RECOMMENDED_UNDER_12, FORBIDDEN_UNDER_12, NOT_RECOMMENDED_UNDER_16, FORBIDDEN_UNDER_16;
    }

    public enum MovieGenre {
        ROMANCE, ACTION, COMEDY, DRAMA, FAMILY, DOCUMENTARY, FANTASY
    }

    public String getName() {
        return name;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }
}
