package com.example.cinemaapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(CinemaApplication.class);

    //https://www.jetbrains.com/help/idea/your-first-spring-application.html#add-greeting-method
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    //https://spring.io/guides/gs/accessing-data-jpa
    @Bean
    public CommandLineRunner demo(MovieRepository repository) {
        return (args) -> {
            // save a few movies
            repository.save(new Movie("Taevast sajab lihapalle"));
            repository.save(new Movie("Harry Potter ja tarkade kivi"));
            repository.save(new Movie("Kuidas taltsutada lohet"));

            // fetch all movies
            log.info("Movies found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(movie -> {
                log.info(movie.toString());
            });
            log.info("");

        };
    }

}
