package com.gcit.siva.bookmyshow.repository;

import com.gcit.siva.bookmyshow.DTO.TheaterIdDto;
import com.gcit.siva.bookmyshow.entity.ShowScreen;
import com.gcit.siva.bookmyshow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShowScreenRepo extends JpaRepository<ShowScreen,Long> {

    @Query(value = "select * from show_screen where movie_id= :movieId",nativeQuery = true)
    List<ShowScreen> findAllShowScreeByMovieID (@Param("movieId") long movieId);

    @Query(value = "select * from show_screen where theater_id= :theaterID and movie_id = :movieID",nativeQuery = true)
    ShowScreen findShowScreenByTheaterIDAndMovieID (@Param("theaterID") long theaterID, @Param("movieID") long movieId);

   // @Query(value = "update Show_Screen SET booked_seat = booked_seat - :numOfTickets WHERE show_id= :show_id",nativeQuery = true)
    //ShowScreen updateBookedSeatInScreenShow (@Param("numOfTickets") int numOfTickets,@Param("show_id") long show_id );

    @Query(value = "select  distinct(theater_id) from show_screen where movie_id = :id",nativeQuery = true)
    List<Long> findTheaterIdByMovieId(@Param("id") long id);

    @Query(value = "select  distinct(movie_id) from show_screen where theater_id = :id",nativeQuery = true)
    List<Long> findMovieIdByTheaterId(@Param("id") long id);

//    @Query(value = "select distinct(:disId) from show_screen where :whereId = :Id ",nativeQuery = true)
//    List<Long> findIdForDistinctColumn(@Param("disId") String disId,@Param("whereId") String whereId,@Param("Id") long Id);

//    @Query("distinct(theaterId),date from ShowScreen where movieId = :movieId ")
//    List<TheaterIdDto> findTheaterIdByMovieId2(@Param("movieId") long movieId);

    @Query(value = "select * from show_screen where theater_id = :theaterId",nativeQuery = true)
    List<ShowScreen> getAllShowsByTheaterID(@Param("theaterId") long theaterId);

    @Query(value = "select * from show_screen where movie_id = :movie_id",nativeQuery = true)
    List<ShowScreen> getAllShowsByMovieId(@Param("movie_id") long movie_id);

    @Modifying
    @Transactional
    @Query(value = "update show_screen set booked_seat =  :numOfSeat  where show_id= :showId",nativeQuery = true)
    void decreaseCountOfBookedSeat (@Param("numOfSeat") int numOfSeat , @Param("showId") long showId);



}
