package com.gcit.siva.bookmyshow.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowScreenTimingDto {

    private long showId;

    private LocalDateTime date;

    private int totalSeat;

    private int bookedSeat;
}
