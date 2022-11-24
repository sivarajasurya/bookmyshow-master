package com.gcit.siva.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class Theater{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private long theaterId;

    @Column(name = "theater_name")
    @NotBlank(message = "Enter a valid input")
    private String theaterName;

    @OneToMany(mappedBy = "theater")
    @JsonBackReference
    private List<ShowScreen> showScreens;

}
