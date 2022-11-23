package com.gcit.siva.bookmyshow.DTO.ListAllShowTimingsByTheaterNameOrMovieName.ListAllTheaterByMovieName;

import com.gcit.siva.bookmyshow.DTO.ListAllShowTimingsByTheaterNameOrMovieName.ShowScreenTimingDto;
import lombok.Data;
import java.util.List;

@Data
public class AllTheaterByMovieNameDto {

    private String movieName;

    private String theaterName;

    private List<ShowScreenTimingDto> showScreens;

}
