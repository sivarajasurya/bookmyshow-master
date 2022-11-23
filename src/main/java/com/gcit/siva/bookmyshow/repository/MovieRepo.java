package com.gcit.siva.bookmyshow.repository;

import com.gcit.siva.bookmyshow.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

    @Query(value = "select * from Movie where movie_name = :movieName", nativeQuery = true)
    Movie findMovieByMovieName(@Param("movieName") String movieName);
}
