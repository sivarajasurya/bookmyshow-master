package com.gcit.siva.bookmyshow.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterRequest {

    private long theaterId;
    private String theaterName;
}
