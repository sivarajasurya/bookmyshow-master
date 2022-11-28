package com.gcit.siva.bookmyshow.controller;

import com.gcit.siva.bookmyshow.dto.BookSeatForShowRequest;
import com.gcit.siva.bookmyshow.dto.BookSeatForShowResponse;
import com.gcit.siva.bookmyshow.dto.AllMoviesByTheaterNameDto;
import com.gcit.siva.bookmyshow.dto.AllTheaterByMovieNameDto;
import com.gcit.siva.bookmyshow.dto.SeatAvailableDto;
import com.gcit.siva.bookmyshow.entity.ShowScreen;
import com.gcit.siva.bookmyshow.dto.request.ShowRequest;
import com.gcit.siva.bookmyshow.service.ShowScreenService;
import com.gcit.siva.bookmyshow.service.MovieService;
import com.gcit.siva.bookmyshow.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ShowScreenController {

    @Autowired
    private ShowScreenService service;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private MovieService movieService;

    @PostMapping("/saveSeatDetails/{theaterId}/{movieID}")
    private ShowScreen saveSeatDetails(@PathVariable long theaterId, @PathVariable long movieID , @RequestBody ShowRequest showRequest){
        return service.saveShow( theaterId , movieID ,showRequest);
    }

    @GetMapping("/findAllShowScreenByMovieNames")
    public List<ShowScreen> showScreenList (){
        return service.findAllShowScreen();
    }

    @GetMapping("/findAllShowScreenByMoviesName/{movieName}")
    public List<AllTheaterByMovieNameDto> findAllShowScreenByMovieName(@PathVariable String movieName){
        return service.findAllShowScreenByMovieName(movieName);
    }

    @GetMapping("/findAllShowScreenByTheaterName/{theaterName}")
    public AllMoviesByTheaterNameDto findAllShowScreenByTheaterName(@PathVariable String theaterName){
        return service.findAllShowScreenByTheaterName(theaterName);
    }

    @GetMapping("/getTicketAvailabilityByScreenId/{screenId}")
    public SeatAvailableDto getTicketAvailabilityByScreenId(@PathVariable long screenId){
        return service.getTicketAvailabilityByScreenId(screenId);
    }

    @GetMapping("/getShowScreenByShowId/{showId}")
    public ShowScreen getShowScreenByShowId(@PathVariable long showId){
        return service.getShowScreenByShowId(showId);
    }

    @GetMapping("/bookSeatForShowScreen/{showId}/{numOfTickets}")
    public BookSeatForShowResponse bookSeatForShowScreens(@PathVariable long showId, @PathVariable int numOfTickets){
        return service.bookSeatAvailableForShowScreens(showId,numOfTickets);
    }

    @PostMapping("/bookSeatForShowScreen")
    public BookSeatForShowResponse bookSeatForShowScreen( @RequestBody BookSeatForShowRequest bookSeatForShowRequest){
        return service.bookSeatAvailableForShowScreen(bookSeatForShowRequest);
    }

    @GetMapping("/findAllShowScreen")
    public List<ShowScreen> findAllShowScreen(){
        return service.findAllShowScreen();
    }

}
