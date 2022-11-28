package com.gcit.siva.bookmyshow;

import com.gcit.siva.bookmyshow.dto.AllMoviesByTheaterNameDto;
import com.gcit.siva.bookmyshow.dto.AllTheaterByMovieNameDto;
import com.gcit.siva.bookmyshow.dto.BookSeatForShowResponse;
import com.gcit.siva.bookmyshow.dto.SeatAvailableDto;
import com.gcit.siva.bookmyshow.dto.request.ShowRequest;
import com.gcit.siva.bookmyshow.entity.Movie;
import com.gcit.siva.bookmyshow.entity.ShowScreen;
import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.service.MovieService;
import com.gcit.siva.bookmyshow.service.ShowScreenService;
import com.gcit.siva.bookmyshow.service.TheaterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceShowScreenTest {

    @Autowired
    private TheaterService theaterService;
    @Autowired
    private ShowScreenService showScreenService;
    @Autowired
    private MovieService movieService;

    Theater theater ;
    Movie movie;
    ShowRequest showRequest;

    @Before
    @Transactional
    public void obj(){
       theater=new Theater();
        theater.setTheaterName("imax");
        Theater theater1 = theaterService.saveTheaterName(theater);
        System.out.println(theater1.toString());

        movie = new Movie();
        movie.setMovieName("avatar 2");
        Movie movie1 = movieService.saveMovieName(movie);
        System.out.println(movie1.toString());


        showRequest=new ShowRequest();
        showRequest.setBookedSeat(23);
        showRequest.setTotalSeat(240);
        showRequest.setDate(LocalDate.of(2022, 1, 13).atTime(1, 50, 9));
        ShowScreen showScreen = showScreenService.saveShow(theater1.getTheaterId(), movie1.getMovieId(), showRequest);
        System.out.println(showScreen.toString());
    }

    @Test
    @Transactional
    public void getAllShowScreenTest() {
        List<ShowScreen> allShowScreen = showScreenService.findAllShowScreen();
        assertEquals(15, allShowScreen.stream().count());
    }

    @Test
    @Transactional
    public void saveShowScreenTest() {
        ShowScreen showScreen1 = showScreenService.saveShow(4l, 2l, showRequest);
        System.out.println(showScreen1);
        assertEquals("pvr", showScreen1.getTheater().getTheaterName());
    }

    @Test
    @Transactional
    public void findShowScreenByIdTest(){
        ShowScreen showScreenByShowId = showScreenService.getShowScreenByShowId(1l);
        assertEquals(Optional.of(1l),Optional.of(showScreenByShowId.getShowId()));
    }

    @Test
    @Transactional
    public void getTicketAvailabilityByScreenIdTest(){
        ShowScreen showScreen = showScreenService.getShowScreenByShowId(1L);
        SeatAvailableDto SeatAvailableDto = showScreenService.getTicketAvailabilityByScreenId(showScreen.getShowId());
        assertEquals(2,SeatAvailableDto.getAvailableSeats());
    }

    @Test
    @Transactional
    public void bookSeatAvailableForShowScreensTest(){
        ShowScreen showScreen = showScreenService.getShowScreenByShowId(1L);
        int numOfTickets =6;
        BookSeatForShowResponse bookSeatForShowResponse = showScreenService.bookSeatAvailableForShowScreens(showScreen.getShowId(), numOfTickets);
        assertEquals("The Ticket has not been booked",bookSeatForShowResponse.getStatus());
    }

    @Test
    @Transactional
    public void findAllShowScreenByMovieNameTest(){
        List<AllTheaterByMovieNameDto> black_panther = showScreenService.findAllShowScreenByMovieName("Black Panther");
        assertEquals(1,black_panther.stream().count());
    }

    @Test
    @Transactional
    public void findAllShowScreenByTheaterNameTest(){
        AllMoviesByTheaterNameDto luxe = showScreenService.findAllShowScreenByTheaterName("luxe");
        assertEquals("luxe",luxe.getTheaterName());
    }
}
