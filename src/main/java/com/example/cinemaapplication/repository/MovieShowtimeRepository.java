package com.example.cinemaapplication.repository;

import com.example.cinemaapplication.model.Movie;
import com.example.cinemaapplication.model.MovieShowtime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieShowtimeRepository extends CrudRepository<MovieShowtime, Long> {

    @Query("SELECT mst FROM MovieShowtime mst JOIN Movie m ON mst.movie = m " +
            "WHERE (m.genre = :genre OR :genre IS NULL)" +
            "AND (m.ageLimit = :ageLimit OR :ageLimit IS NULL)" +
            "AND (mst.language = :language OR :language IS NULL)" +
            "AND (m.timeInMinutes > :minLength OR :minLength IS NULL)" +
            "AND (m.timeInMinutes < :maxLength OR :maxLength IS NULL)" +
            "AND (EXTRACT(HOUR FROM mst.time) >= :earliestStartHour OR :earliestStartHour IS NULL)")

    Iterable<MovieShowtime> findByFilters(Movie.MovieGenre genre, Movie.AgeLimit ageLimit,
                                                 MovieShowtime.Language language, Integer minLength, Integer maxLength, Integer earliestStartHour);




}
