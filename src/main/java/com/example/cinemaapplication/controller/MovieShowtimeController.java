package com.example.cinemaapplication.controller;

import com.example.cinemaapplication.model.MovieShowtime;
import com.example.cinemaapplication.repository.MovieRepository;
import com.example.cinemaapplication.repository.MovieShowtimeRepository;
import com.example.cinemaapplication.service.MovieShowtimeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/showtimes")
public class MovieShowtimeController {
    MovieRepository movieRepository;

    MovieShowtimeRepository movieShowtimeRepository;
    MovieShowtimeService movieShowtimeService;

    @Autowired
    public MovieShowtimeController(MovieRepository movieRepository, MovieShowtimeRepository movieShowtimeRepository, MovieShowtimeService movieShowtimeService) {
        this.movieRepository = movieRepository;
        this.movieShowtimeRepository = movieShowtimeRepository;
        this.movieShowtimeService = movieShowtimeService;
    }

    @GetMapping()
    public Iterable<MovieShowtime> getShowtimes() {
        return movieShowtimeService.getShowtimes();
    }
}
