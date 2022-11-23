package com.gcit.siva.bookmyshow.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TheaterIdDto {
    private LocalDateTime date;
    private long theaterId;
}
