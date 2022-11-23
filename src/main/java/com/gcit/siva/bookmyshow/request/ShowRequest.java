package com.gcit.siva.bookmyshow.request;

import lombok.Data;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class ShowRequest {

    private LocalDateTime date;
    private int totalSeat;
    private int bookedSeat;
}
