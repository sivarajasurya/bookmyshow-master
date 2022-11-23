package com.gcit.siva.bookmyshow.DTO.ListAllShowTimingsByTheaterNameOrMovieName.ListAllMoviesByTheaterName;


import lombok.Data;

import java.util.List;

@Data
public class AllMoviesByTheaterNameDto {
    private String theaterName;
    private List<MovieNameDto> movieName;

}
