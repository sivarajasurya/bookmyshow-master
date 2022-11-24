package com.gcit.siva.bookmyshow.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowRequest {

    private LocalDateTime date;
    private int totalSeat;
    private int bookedSeat;
}
