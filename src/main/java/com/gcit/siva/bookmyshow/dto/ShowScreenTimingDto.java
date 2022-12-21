package com.gcit.siva.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowScreenTimingDto {

    private long showId;
    private LocalDateTime date;
    private int totalSeat;
    private int bookedSeat;
}
