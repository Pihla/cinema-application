package com.example.cinemaapplication.controller;

import com.example.cinemaapplication.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @GetMapping()
    public String[][] getSeats(@RequestParam(value = "numberOfSeats", defaultValue = "1") int numberOfSeats) {
        return new SeatService().recommendSeats(numberOfSeats);
    }
}
