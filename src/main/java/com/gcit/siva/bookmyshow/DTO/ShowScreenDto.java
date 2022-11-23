package com.gcit.siva.bookmyshow.DTO;

import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.entity.Theater;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class ShowScreenDto {

    private long showId;

    private LocalDateTime date;

    private int totalSeat;

    private int bookedSeat;

    private Theater theater;

    private Movie movie;

}
