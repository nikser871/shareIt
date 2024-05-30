package ru.shareit.booking.repository;

import ru.shareit.booking.Booking;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface RepositoryBooking {
    Map<Long, HashSet<Booking>> getBookingsByID(long ownerId);
    Booking bookItem(long itemId, long userId, int days);
    String confirmBooking(long itemId, long bookingId, long ownerId);


}
