package com.example.cinemaapplication.service;

import com.example.cinemaapplication.model.MovieShowtime;
import com.example.cinemaapplication.repository.MovieRepository;
import com.example.cinemaapplication.repository.MovieShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieShowtimeService {
    MovieRepository movieRepository;

    MovieShowtimeRepository movieShowtimeRepository;

    @Autowired
    public MovieShowtimeService(MovieRepository movieRepository, MovieShowtimeRepository movieShowtimeRepository) {
        this.movieRepository = movieRepository;
        this.movieShowtimeRepository = movieShowtimeRepository;
    }

    public Iterable<MovieShowtime> getShowtimes() {
        return movieShowtimeRepository.findAll();
    }


}
