package com.gcit.siva.bookmyshow.service.movieService;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.request.MovieRequest;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie saveMovieName (MovieRequest movie);

    List<Movie> listMovieNames ();

    Movie findMovieById(long id);

    Movie findMovieByMovieName(String movieName);
}
