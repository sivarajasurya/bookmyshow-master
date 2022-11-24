package com.gcit.siva.bookmyshow.service.impl;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.repository.ShowScreenRepo;
import com.gcit.siva.bookmyshow.repository.TheaterRepo;
import com.gcit.siva.bookmyshow.dto.request.TheaterRequest;
import com.gcit.siva.bookmyshow.service.MovieService;
import com.gcit.siva.bookmyshow.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterRepo theaterRepo;

    @Autowired
    private ShowScreenRepo showScreenRepo;

    @Autowired
    private MovieService movieService;

    @Override
    public Theater saveTheaterName(TheaterRequest theater) {
        Theater theater1 = new Theater();
        theater1.setTheaterName(theater.getTheaterName());
        return theaterRepo.save(theater1);
    }

    @Override
    public List<Theater> listAllTheaterName() {
        return theaterRepo.findAll();
    }

    @Override
    public Theater findByID(long id) {
        Optional<Theater> optionalTheater = theaterRepo.findById(id);
        if (optionalTheater.isPresent()){
            return optionalTheater.get();
        }throw new RuntimeException("Theater not found " + id);
    }

    @Override
    public  Theater findTheaterByTheaterNames(String theaterName){
        Theater theater = theaterRepo.findTheaterByTheaterName(theaterName);
        return theater;
    }

    @Override
    public List<Theater> findTheaterNameForMovieName(String movieName){

        Movie movie = movieService.findMovieByMovieName(movieName);
        List<Theater> list = new ArrayList<>();

        if (movie != null){
            long movieID = movie.getMovieId();
        List<Long> theaterIdByMovieId = showScreenRepo.findTheaterIdByMovieId(movieID);
        for(Long l : theaterIdByMovieId){
            list.add(this.findByID(l));
        }}
        return list;
    }



}

