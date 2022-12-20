package com.gcit.siva.bookmyshow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private long theaterId;

    @Column(name = "theater_name")
    @NotBlank(message = "Enter a valid input")
    private String theaterName;

    @JsonBackReference
    @OneToMany(mappedBy = "theater")
    private List<ShowScreen> showScreens;

}
