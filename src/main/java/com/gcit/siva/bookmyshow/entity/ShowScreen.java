package com.gcit.siva.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "show_screen" ,schema = "entertainment")
public class ShowScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long showId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "total_seat")
    private Integer totalSeat;

    @Column(name = "booked_seat")
    private Integer bookedSeat;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonManagedReference
    private Theater theater;

}
