package ru.shareit.booking.repository;

import ru.shareit.booking.Booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepoBookingImpl implements RepositoryBooking {
    public Map<Long, Set<Booking>> bookings = new HashMap<>();

}
