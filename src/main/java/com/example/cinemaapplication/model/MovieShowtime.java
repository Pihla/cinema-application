package com.example.cinemaapplication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class MovieShowtime {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Movie movie;

    private LocalDateTime time;
    private Language language;

    public MovieShowtime(Movie movie, LocalDateTime time, Language language) {
        this.movie = movie;
        this.time = time;
        this.language = language;
    }

    public String toString() {
        return movie.toString() + " " + time.toString();
    }
    protected MovieShowtime() {

    }

    public enum Language {
        ESTONIAN, ENGLISH, RUSSIAN
    }


    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Language getLanguage() {
        return language;
    }
}
