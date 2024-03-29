package com.example.cinemaapplication.service;

import com.example.cinemaapplication.model.Movie;
import com.example.cinemaapplication.model.MovieShowtime;
import com.example.cinemaapplication.repository.UserViewingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class UserViewingService {


    UserViewingRepository userViewingRepository;

    @Autowired
    public UserViewingService(UserViewingRepository userViewingRepository) {
        this.userViewingRepository = userViewingRepository;
    }


    public Iterable<MovieShowtime> getRecommendations() {
        return userViewingRepository.getShowtimesWithMostViewedGenre();
    }

}
