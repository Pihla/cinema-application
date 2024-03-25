package com.example.cinemaapplication.repository;
import java.util.List;

import com.example.cinemaapplication.model.Movie;
import org.springframework.data.repository.CrudRepository;

//https://spring.io/guides/gs/accessing-data-jpa
public interface MovieRepository extends CrudRepository<Movie, Long>{

    List<Movie> findByName(String name);

    Movie findById(long id);
}
