package com.example.cinemaapplication;

import com.example.cinemaapplication.model.Movie;
import com.example.cinemaapplication.model.MovieShowtime;
import com.example.cinemaapplication.repository.MovieRepository;
import com.example.cinemaapplication.repository.MovieShowtimeRepository;
import com.example.cinemaapplication.service.MovieShowtimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(CinemaApplication.class);



    //https://spring.io/guides/gs/accessing-data-jpa
    @Bean
    public CommandLineRunner demo(MovieRepository movieRepository, MovieShowtimeRepository showtimeRepository, MovieShowtimeService movieShowtimeService) {
        return (args) -> {
            // save a few movies
            Movie movie_meatballs = new Movie("Taevast sajab lihapalle", Movie.MovieGenre.FAMILY, Movie.AgeLimit.NO_LIMIT, 82);
            Movie movie_harry_potter = new Movie("Harry Potter ja tarkade kivi", Movie.MovieGenre.FANTASY, Movie.AgeLimit.NOT_RECOMMENDED_UNDER_12, 96);
            movieRepository.save(movie_harry_potter);
            movieRepository.save(movie_meatballs);

            // fetch all movies
            log.info("Movies found with findAll():");
            log.info("-------------------------------");
            movieRepository.findAll().forEach(movie -> {
                log.info(movie.toString());
            });
            log.info("");

            // save a few movie showtimes
            MovieShowtime showtime_hp_1 = new MovieShowtime(movie_harry_potter, LocalDateTime.of(2024, 3, 28, 14, 30, 0, 0), MovieShowtime.Language.ENGLISH);
            MovieShowtime showtime_meatballs_1 = new MovieShowtime(movie_meatballs,  LocalDateTime.of(2024, 3, 28, 14, 30, 0, 0), MovieShowtime.Language.ESTONIAN);
            MovieShowtime showtime_hp_2 = new MovieShowtime(movie_harry_potter,  LocalDateTime.of(2024, 3, 29, 18, 0, 0, 0), MovieShowtime.Language.ENGLISH);
            MovieShowtime showtime_meatballs_2 = new MovieShowtime(movie_meatballs, LocalDateTime.of(2024, 3, 29, 11, 0, 0, 0), MovieShowtime.Language.RUSSIAN);
            showtimeRepository.save(showtime_hp_1);
            showtimeRepository.save(showtime_hp_2);
            showtimeRepository.save(showtime_meatballs_1);
            showtimeRepository.save(showtime_meatballs_2);


            // fetch all showtimes
            log.info("Showtimes found with findAll():");
            log.info("-------------------------------");
            showtimeRepository.findAll().forEach(showtime -> {
                log.info(showtime.toString());
            });

            // fetch showtimes with condition
            log.info("Showtimes found with condition:");
            log.info("-------------------------------");
            movieShowtimeService.getShowtimesByFilters("FANTASY", null, null, null, null, 17 ).forEach(showtime -> {
                log.info(showtime.toString());
            });

        };
    }

}
