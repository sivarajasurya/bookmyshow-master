package com.gcit.siva.bookmyshow;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceMovieTest {

    @Autowired
    private MovieService movieService;

    @Test
    @Transactional
    public void saveMovieNameTest() {
        Movie movie = new Movie();
        movie.setMovieName("black adam");
        Movie movie1 = movieService.saveMovieName(movie);
        assertEquals("black adam", movie1.getMovieName());
    }

    @Test
    @Transactional
    public void listMovieNamesTest() {
        List<Movie> moviesList = movieService.listMovieNames();
        assertEquals(6, moviesList.stream().count());
    }

    @Test
    @Transactional
    public void findMovieByIdTest() {
        Movie movieById = movieService.findMovieById(2l);
        assertEquals(2l, movieById.getMovieId());
    }

    @Test
    @Transactional
    public void findMovieByMovieNameTest() {
        Movie movie = movieService.findMovieByMovieName("avangers");
        assertEquals("avangers", movie.getMovieName());
    }

}
