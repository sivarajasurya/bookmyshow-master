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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity saveSeatDetails(@PathVariable long theaterId, @PathVariable long movieID , @RequestBody ShowRequest showRequest){
        ShowScreen showScreen = service.saveShow(theaterId, movieID, showRequest);
        return (showScreen!=null) ? new ResponseEntity<>(showScreen, HttpStatus.OK) : new ResponseEntity<>("Show screen is not saved ,Theater Id or Movie ID is not available",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAllShowScreen")
    public ResponseEntity showScreenList (){
        List<ShowScreen> allShowScreen = service.findAllShowScreen();
        return (allShowScreen!=null) ? new ResponseEntity<>(allShowScreen, HttpStatus.OK) : new ResponseEntity<>("No Show was found  ",HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/findAllShowScreenByMoviesName/{movieName}")
    public ResponseEntity findAllShowScreenByMovieName(@PathVariable String movieName){
        List<AllTheaterByMovieNameDto> allShowScreenByMovieName = service.findAllShowScreenByMovieName(movieName);
        return (allShowScreenByMovieName!=null) ? new ResponseEntity<>(allShowScreenByMovieName, HttpStatus.OK) :new ResponseEntity<>("No Show was found for the movie name "+ movieName,HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/findAllShowScreenByTheaterName/{theaterName}")
    public ResponseEntity findAllShowScreenByTheaterName(@PathVariable String theaterName){
        AllMoviesByTheaterNameDto allShowScreenByTheaterName = service.findAllShowScreenByTheaterName(theaterName);
        return (allShowScreenByTheaterName!=null) ? new ResponseEntity<>(allShowScreenByTheaterName, HttpStatus.OK) :new ResponseEntity<>("No Show was found  for theater name "+ theaterName,HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getTicketAvailabilityByScreenId/{screenId}")
    public ResponseEntity getTicketAvailabilityByScreenId(@PathVariable long screenId){
        SeatAvailableDto ticketAvailabilityByScreenId = service.getTicketAvailabilityByScreenId(screenId);
        return (ticketAvailabilityByScreenId!=null) ? new ResponseEntity<>(ticketAvailabilityByScreenId, HttpStatus.OK) :new ResponseEntity<>("Show Screen ID not found "+ screenId,HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getShowScreenByShowId/{showId}")
    public ResponseEntity getShowScreenByShowId(@PathVariable long showId){
        ShowScreen showScreenByShowId = service.getShowScreenByShowId(showId);
        return (showScreenByShowId!=null) ? new ResponseEntity<>(showScreenByShowId, HttpStatus.OK) :new ResponseEntity<>("Show Screen ID not found "+ showId,HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/bookSeatForShowScreen/{showId}/{numOfTickets}")
    public ResponseEntity bookSeatForShowScreens(@PathVariable long showId, @PathVariable int numOfTickets){
        BookSeatForShowResponse bookSeatForShowResponse = service.bookSeatAvailableForShowScreens(showId, numOfTickets);
        return (bookSeatForShowResponse!=null) ? new ResponseEntity<>(bookSeatForShowResponse, HttpStatus.OK) :new ResponseEntity<>("Show Screen ID not found "+ showId,HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/bookSeatForShowScreen")
    public ResponseEntity bookSeatForShowScreen( @RequestBody BookSeatForShowRequest bookSeatForShowRequest){
        BookSeatForShowResponse bookSeatForShowResponse = service.bookSeatAvailableForShowScreen(bookSeatForShowRequest);
        return (bookSeatForShowResponse!=null) ? new ResponseEntity<>(bookSeatForShowResponse, HttpStatus.OK) :new ResponseEntity<>("Show Screen ID not found "+ bookSeatForShowRequest.getShowId(),HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/findAllShowScreenss")
    public ResponseEntity findAllShowScreen(){
        List<ShowScreen> allShowScreen = service.findAllShowScreen();
        return (!allShowScreen.isEmpty()) ? new ResponseEntity<>(allShowScreen, HttpStatus.OK) :new ResponseEntity<>("No Show Screen is present",HttpStatus.BAD_REQUEST);

    }

}
