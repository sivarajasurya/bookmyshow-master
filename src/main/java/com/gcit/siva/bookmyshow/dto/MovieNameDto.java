package com.gcit.siva.bookmyshow.dto;

import com.gcit.siva.bookmyshow.dto.ShowScreenTimingDto;
import lombok.Data;

import java.util.List;

@Data
public class MovieNameDto {
    private String movieName;
    private List<ShowScreenTimingDto> screenTiming;
}
