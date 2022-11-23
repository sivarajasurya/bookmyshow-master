package com.gcit.siva.bookmyshow.DTO;

import lombok.Data;

@Data
public class SeatAvailableDto {

    private String theaterName;
    private String movieName;
    private int AvailableSeats;
}
