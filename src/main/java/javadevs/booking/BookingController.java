package javadevs.booking;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

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

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookings.stream()
                .filter(bkg -> bkg.getPricePerNight() <= price)
                .collect(Collectors.toList());

    }
}
