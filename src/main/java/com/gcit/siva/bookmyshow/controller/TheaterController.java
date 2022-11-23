package com.gcit.siva.bookmyshow.controller;

import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.request.TheaterRequest;
import com.gcit.siva.bookmyshow.service.theaterService.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheaterName")
    public Theater theater (@RequestBody TheaterRequest theater){

        return theaterService.saveTheaterName(theater);
    }
    @GetMapping("/showAllTheaterName")
    public List<Theater> theaters (){
        return theaterService.listAllTheaterName();
    }

    @GetMapping("/findTheaterByTheaterName/{theaterName}")
    public Theater findTheaterByTheaterName(@PathVariable String theaterName){
        return theaterService.findTheaterByTheaterNames(theaterName);
    }
    @GetMapping("/findAllTheaterByMovieName/{movieName}")
    public List<Theater> findAllTheaterByMovieName(@PathVariable String movieName){
        return theaterService.findTheaterNameForMovieName(movieName);
    }

}
