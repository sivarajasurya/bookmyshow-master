package com.gcit.siva.bookmyshow.service.movieService;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.repository.MovieRepo;
import com.gcit.siva.bookmyshow.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie saveMovieName(MovieRequest movie) {
        Movie movie1 = new Movie();
        movie1.setMovieName(movie.getMovieName());
        return movieRepo.save(movie1);
    }

    @Override
    public List<Movie> listMovieNames() {
        return movieRepo.findAll();
    }

    @Override
    public Movie findMovieById(long id) {
        Optional<Movie> movie = movieRepo.findById(id);

        if (movie.isPresent()){
            return movie.get();
        }throw new RuntimeException("Movie not found " + id);
    }

    @Override
    public Movie findMovieByMovieName(String movieName){
        return movieRepo.findMovieByMovieName(movieName);
    }
}
