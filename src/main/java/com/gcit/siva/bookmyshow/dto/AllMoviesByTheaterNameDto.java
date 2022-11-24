package com.gcit.siva.bookmyshow.dto;


import lombok.Data;

import java.util.List;

@Data
public class AllMoviesByTheaterNameDto {
    private String theaterName;
    private List<MovieNameDto> movieName;

}
