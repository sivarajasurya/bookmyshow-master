package com.gcit.siva.bookmyshow.controller;

import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.dto.request.TheaterRequest;
import com.gcit.siva.bookmyshow.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheaterName")
    public ResponseEntity theater (@RequestBody TheaterRequest theater){
        Theater obj = theaterService.saveTheaterName(theater);
//        max = (a > b) ? a : b;
        return (obj!=null)?new ResponseEntity<>(obj,HttpStatus.OK) : new ResponseEntity<>("Theater is not added ",HttpStatus.BAD_REQUEST) ;
    }
    @GetMapping("/showAllTheaterName")
    public ResponseEntity theaters (){
        List<Theater> obj = theaterService.listAllTheaterName();
        if(obj != null){
            return new ResponseEntity<>(obj,HttpStatus.OK);
        } else {
            return  new ResponseEntity<>("Theater not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findTheaterByTheaterName/{theaterName}")
    public ResponseEntity findTheaterByTheaterName(@PathVariable String theaterName) {
        Theater theater = theaterService.findTheaterByTheaterNames(theaterName);
        if(theater != null){
            return new ResponseEntity<>(theater,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Theater not found",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAllTheaterByMovieName/{movieName}")
    public ResponseEntity findAllTheaterByMovieName(@PathVariable String movieName){
        List<Theater> obj = theaterService.findTheaterNameForMovieName(movieName);
        if (!obj.isEmpty()){
            return new ResponseEntity<>(obj,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No theater has been found for the movie name" + movieName,HttpStatus.NOT_FOUND);
        }
    }

}
