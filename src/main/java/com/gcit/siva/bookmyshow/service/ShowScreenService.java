package com.gcit.siva.bookmyshow.service;

import com.gcit.siva.bookmyshow.dto.BookSeatForShowRequest;
import com.gcit.siva.bookmyshow.dto.BookSeatForShowResponse;
import com.gcit.siva.bookmyshow.dto.AllMoviesByTheaterNameDto;
import com.gcit.siva.bookmyshow.dto.AllTheaterByMovieNameDto;
import com.gcit.siva.bookmyshow.dto.SeatAvailableDto;
import com.gcit.siva.bookmyshow.entity.ShowScreen;
import com.gcit.siva.bookmyshow.dto.request.ShowRequest;

import java.util.List;

public interface ShowScreenService {

    ShowScreen saveShow (long theaterID, long movieId, ShowRequest showRequest);
    List<ShowScreen> findAllShowScreen();
    SeatAvailableDto getTicketAvailabilityByScreenId(long id);
    BookSeatForShowResponse bookSeatAvailableForShowScreen(BookSeatForShowRequest showRequest);
    BookSeatForShowResponse bookSeatAvailableForShowScreens(long showId,int numOfTickets);
    AllMoviesByTheaterNameDto findAllShowScreenByTheaterName(String theaterName);
    List<AllTheaterByMovieNameDto> findAllShowScreenByMovieName(String movieName);

    ShowScreen getShowScreenByShowId(long showId);
}
