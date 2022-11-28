package com.gcit.siva.bookmyshow.dto;

import com.gcit.siva.bookmyshow.dto.ShowScreenTimingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllTheaterByMovieNameDto {

    private String movieName;

    private String theaterName;

    private List<ShowScreenTimingDto> showScreens;

}
