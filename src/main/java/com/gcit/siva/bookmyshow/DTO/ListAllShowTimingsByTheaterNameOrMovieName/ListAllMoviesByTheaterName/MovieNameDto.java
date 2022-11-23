package com.gcit.siva.bookmyshow.DTO.ListAllShowTimingsByTheaterNameOrMovieName.ListAllMoviesByTheaterName;

import com.gcit.siva.bookmyshow.DTO.ListAllShowTimingsByTheaterNameOrMovieName.ShowScreenTimingDto;
import lombok.Data;

import java.util.List;

@Data
public class MovieNameDto {
    private String movieName;
    private List<ShowScreenTimingDto> screenTiming;
}
