package com.gcit.siva.bookmyshow.service.theaterService;

import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.request.TheaterRequest;

import java.util.List;
import java.util.Optional;

public interface TheaterService {

    Theater saveTheaterName (TheaterRequest theater);
    List<Theater> listAllTheaterName ();
    Theater findByID(long id);
    Theater findTheaterByTheaterNames(String theaterName);
    List<Theater> findTheaterNameForMovieName(String movieName);
}
