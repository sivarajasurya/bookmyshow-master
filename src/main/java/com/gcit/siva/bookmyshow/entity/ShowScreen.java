package com.gcit.siva.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gcit.siva.bookmyshow.dto.request.ShowRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "show_screen", schema = "entertainment")
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

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Override
    public String toString() {
        return "ShowScreen{" + "showId=" + showId + ", date=" + date + ", totalSeat=" + totalSeat + ", bookedSeat=" + bookedSeat + ", movie=" + movie.getMovieId() + movie.getMovieName() + ", theater=" + theater.getTheaterId() + theater.getTheaterName() + '}';
    }
}
