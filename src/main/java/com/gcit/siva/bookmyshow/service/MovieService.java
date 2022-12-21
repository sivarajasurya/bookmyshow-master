package com.gcit.siva.bookmyshow.service;

import com.gcit.siva.bookmyshow.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie saveMovieName(Movie movie);

    List<Movie> listMovieNames();

    Movie findMovieById(long id);

    Movie findMovieByMovieName(String movieName);
}
