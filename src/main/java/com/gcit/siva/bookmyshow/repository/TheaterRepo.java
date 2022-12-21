package com.gcit.siva.bookmyshow.repository;

import com.gcit.siva.bookmyshow.entity.ShowScreen;
import com.gcit.siva.bookmyshow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepo extends JpaRepository<Theater, Long> {

    @Query(value = "SELECT * FROM Theater", nativeQuery = true)
    List<Theater> findAllTheater();

    @Query(value = "select * from Theater where theater_name = :theaterName", nativeQuery = true)
    Theater findTheaterByTheaterName(@Param("theaterName") String theaterName);
}
