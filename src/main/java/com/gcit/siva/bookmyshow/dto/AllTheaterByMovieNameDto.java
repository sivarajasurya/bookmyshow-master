package com.gcit.siva.bookmyshow.dto;

import com.gcit.siva.bookmyshow.dto.ShowScreenTimingDto;
import lombok.Data;
import java.util.List;

@Data
public class AllTheaterByMovieNameDto {

    private String movieName;

    private String theaterName;

    private List<ShowScreenTimingDto> showScreens;

}
