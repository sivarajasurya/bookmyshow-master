package com.gcit.siva.bookmyshow.dto;

import lombok.Data;

@Data
public class SeatAvailableDto {

    private String theaterName;
    private String movieName;
    private int AvailableSeats;
}
