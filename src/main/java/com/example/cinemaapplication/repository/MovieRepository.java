package com.example.cinemaapplication.repository;
import java.util.List;

import com.example.cinemaapplication.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
