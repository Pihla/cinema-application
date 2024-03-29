package com.example.cinemaapplication.repository;

import com.example.cinemaapplication.model.Movie;
import com.example.cinemaapplication.model.MovieShowtime;
import com.example.cinemaapplication.model.UserViewing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserViewingRepository extends CrudRepository<UserViewing, Long> {
    @Query("SELECT mst FROM MovieShowtime mst JOIN Movie m ON mst.movie = m " +
            "WHERE m.genre = (SELECT m.genre " +
            "FROM MovieShowtime mst " +
            "JOIN Movie m ON mst.movie = m " +
            "JOIN UserViewing u ON u.movieShowtime = mst " +
            "GROUP BY m.genre " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 1)"
    )
    public Iterable<MovieShowtime> getShowtimesWithMostViewedGenre();
}
