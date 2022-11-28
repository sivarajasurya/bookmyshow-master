package com.gcit.siva.bookmyshow.service;

import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.dto.request.TheaterRequest;

import java.util.List;

public interface TheaterService {

    Theater saveTheaterName (TheaterRequest theater);
    List<TheaterRequest> listAllTheaterName ();
    Theater findByID(long id);
    TheaterRequest findTheaterByTheaterNames(String theaterName);
    List<Theater> findTheaterNameForMovieName(String movieName);
    Theater saveTheaterName(Theater theater);
}
