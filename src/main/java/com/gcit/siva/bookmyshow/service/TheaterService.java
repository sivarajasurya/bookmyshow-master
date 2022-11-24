package com.gcit.siva.bookmyshow.service;

import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.dto.request.TheaterRequest;

import java.util.List;

public interface TheaterService {

    Theater saveTheaterName (TheaterRequest theater);
    List<Theater> listAllTheaterName ();
    Theater findByID(long id);
    Theater findTheaterByTheaterNames(String theaterName);
    List<Theater> findTheaterNameForMovieName(String movieName);
}
