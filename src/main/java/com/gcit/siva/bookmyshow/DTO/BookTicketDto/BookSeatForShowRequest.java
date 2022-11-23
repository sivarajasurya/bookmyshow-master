package com.gcit.siva.bookmyshow.DTO.BookTicketDto;

import lombok.Data;

@Data
public class BookSeatForShowRequest {

    private long showId;
    private int numOfTicket;

}
