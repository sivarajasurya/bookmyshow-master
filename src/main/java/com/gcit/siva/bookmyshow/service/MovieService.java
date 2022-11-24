package com.gcit.siva.bookmyshow.service;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.dto.request.MovieRequest;

import java.util.List;

public interface MovieService {

    Movie saveMovieName (MovieRequest movie);

    List<Movie> listMovieNames ();

    Movie findMovieById(long id);

    Movie findMovieByMovieName(String movieName);
}
