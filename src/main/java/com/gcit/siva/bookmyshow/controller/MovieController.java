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
    public Movie saveMovieNames(@RequestBody MovieRequest movie){
        return movieService.saveMovieName(movie);
    }

    @GetMapping("/listMovieName")
    public ResponseEntity<List<Movie>> listMovieNames(){
        return new  ResponseEntity<List<Movie>>(movieService.listMovieNames(), HttpStatus.OK);
    }


}
