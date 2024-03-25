package com.example.cinemaapplication.repository;

import com.example.cinemaapplication.model.Movie;
import com.example.cinemaapplication.model.MovieShowtime;
import org.springframework.data.repository.CrudRepository;

public interface MovieShowtimeRepository extends CrudRepository<MovieShowtime, Long> {

}
