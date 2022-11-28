package com.gcit.siva.bookmyshow;

import com.gcit.siva.bookmyshow.dto.request.TheaterRequest;
import com.gcit.siva.bookmyshow.entity.Theater;
import com.gcit.siva.bookmyshow.service.TheaterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTheaterTests {

    @Autowired
    private TheaterService theaterService;

    Theater theater;
    List<Theater> theaterList = new ArrayList<>();

    @Before
    @Transactional
    public void obj() {
        theater = new Theater();
        theater.setTheaterName("pvr");
        theaterService.saveTheaterName(theater);
    }

    @Test
    @Transactional
    public void saveTheaterTest() {
        Theater theater1 = theaterService.saveTheaterName(theater);
        assertEquals("pvr",theater1.getTheaterName() );
    }

    @Test
    @Transactional
    public void getTheaterNameTest() {
        TheaterRequest theaterRequest = theaterService.findTheaterByTheaterNames("luxe");
        assertEquals("luxe", theaterRequest.getTheaterName());
    }

    @Test
    @Transactional
    public void getAllTheatersTest() {
        List<TheaterRequest> list = theaterService.listAllTheaterName();
        assertEquals(7, list.stream().count());
    }

    @Test
    @Transactional
    public void findByTheaterIdTest() {
        Theater theaterServiceByID = theaterService.findByID(theater.getTheaterId());
        assertEquals(theater.getTheaterName(), theaterServiceByID.getTheaterName());
    }
}
