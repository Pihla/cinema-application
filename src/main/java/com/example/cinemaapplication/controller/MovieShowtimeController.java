package com.example.cinemaapplication.controller;

import com.example.cinemaapplication.model.MovieShowtime;
import com.example.cinemaapplication.repository.MovieShowtimeRepository;
import com.example.cinemaapplication.service.MovieShowtimeService;
import com.example.cinemaapplication.service.UserViewingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/showtimes")
public class MovieShowtimeController {
    MovieShowtimeRepository movieShowtimeRepository;
    MovieShowtimeService movieShowtimeService;
    UserViewingService userViewingService;

    @Autowired
    public MovieShowtimeController(MovieShowtimeRepository movieShowtimeRepository, MovieShowtimeService movieShowtimeService, UserViewingService userViewingService) {
        this.movieShowtimeRepository = movieShowtimeRepository;
        this.movieShowtimeService = movieShowtimeService;
        this.userViewingService = userViewingService;
    }

    @GetMapping()
    public Iterable<MovieShowtime> getShowtimes(
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "ageLimit", required = false) String agelimit,
            @RequestParam(value = "language", required = false) String language,
            @RequestParam(value = "minLength", required = false) Integer minLength,
            @RequestParam(value = "maxLength", required = false) Integer maxLength,
            @RequestParam(value = "earliestStartHour", required = false) Integer earliestStartHour) {

        return movieShowtimeService.getShowtimesByFilters(genre, agelimit, language, minLength,
                maxLength, earliestStartHour );
    }

    @GetMapping("/recommendations")
    public Iterable<MovieShowtime> getRecommendedShowtimes() {
        return userViewingService.getRecommendations();
    }


}
