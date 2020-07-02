package javadevs.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("AHotel", 150, 4));
        bookings.add(new HotelBooking("BHotel", 200, 3));

        bookingRepository.saveAll(bookings);
    }
}
