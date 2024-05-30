package ru.shareit.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shareit.booking.repository.RepositoryBooking;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController(value = "/bookings")
public class BookingController {

    RepositoryBooking repositoryBooking;

    @Autowired
    public BookingController(RepositoryBooking repositoryBooking) {
        this.repositoryBooking = repositoryBooking;
    }

    @GetMapping
    public Map<Long, HashSet<Booking>> getBookings(@RequestHeader("X-Later-User-Id") long id) {
        return repositoryBooking.getBookingsByID(id);
    }

    @PutMapping(value = "book/{itemId}")
    public Booking bookItem(@PathVariable long itemId, @RequestHeader("X-Later-User-Id") long id, @RequestParam int day) {
        return repositoryBooking.bookItem(itemId, id, day);
    }



}
