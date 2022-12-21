package com.gcit.siva.bookmyshow.controller;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.dto.request.MovieRequest;
import com.gcit.siva.bookmyshow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/saveMovieName")
    public ResponseEntity saveMovieNames(@RequestBody Movie movie) {
        Movie movie1 = movieService.saveMovieName(movie);
        return (movie1 != null) ? new ResponseEntity<>(movie1, HttpStatus.OK) : new ResponseEntity<>("Theater is not added ", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listMovieName")
    public ResponseEntity listMovieNames() {
        List<Movie> movies = movieService.listMovieNames();
        return (movies.stream().count() != 0) ? new ResponseEntity<>(movies, HttpStatus.OK) : new ResponseEntity<>("No movies has been found", HttpStatus.NO_CONTENT);
    }


}
