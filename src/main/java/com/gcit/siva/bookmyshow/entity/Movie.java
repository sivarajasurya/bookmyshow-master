package com.gcit.siva.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "movie_id")
    private long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<ShowScreen> showScreens;

}
