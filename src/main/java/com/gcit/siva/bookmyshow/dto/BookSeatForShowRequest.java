package com.gcit.siva.bookmyshow.dto;

import lombok.Data;

@Data
public class BookSeatForShowRequest {

    private long showId;
    private int numOfTicket;

}
