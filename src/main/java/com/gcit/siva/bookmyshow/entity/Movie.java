package com.gcit.siva.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "movie_id")
    private long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @JsonBackReference
    @OneToMany(mappedBy = "movie")
    private List<ShowScreen> showScreens;

}
