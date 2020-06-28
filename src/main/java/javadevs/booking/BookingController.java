package javadevs.booking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private List<HotelBooking> bookings;

    public BookingController() {
        bookings = new ArrayList<HotelBooking>();

        bookings.add(new HotelBooking("AHotel", 150, 4));
        bookings.add(new HotelBooking("BHotel", 200, 3));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getBookings() {
        return bookings;

    }
}
