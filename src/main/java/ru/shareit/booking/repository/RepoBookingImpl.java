package ru.shareit.booking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shareit.booking.Booking;
import ru.shareit.booking.BookingController;
import ru.shareit.item.Item;
import ru.shareit.item.repository.RepositoryItem;
import ru.shareit.user.repository.RepositoryUser;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.time.LocalDate.now;

public class RepoBookingImpl implements RepositoryBooking {

    private static int ID = 1;
    // Long -- itemId
    public Map<Long, HashSet<Booking>> itemMapBookings = new HashMap<>();
    public Map<Long, Booking> bookingMap = new HashMap<>();


    RepositoryUser repositoryUser;

    RepositoryItem repositoryItem;
    @Autowired
    public RepoBookingImpl(RepositoryItem repositoryItem, RepositoryUser repositoryUser) {
        this.repositoryItem = repositoryItem;
        this.repositoryUser = repositoryUser;
    }


    @Override
    public Map<Long, HashSet<Booking>> getBookingsByID(long ownerId) {

        return repositoryItem.getItems(ownerId)
                .stream()
                .map(Item::getId)
                .collect(Collectors.toMap(x -> x, x -> itemMapBookings.get(x)));
    }

    @Override
    public Booking bookItem(long itemId, long userId, int days) {

        Booking booking = Booking.builder()
                .id(ID++)
                .itemId(itemId)
                .customer(repositoryUser.getUserById(userId))
                .isConfirmed(false)
                .bookingDateStart(now())
                .bookingDateEnd(now().plusDays(days))
                .item(repositoryItem.getItemById(itemId))
                .build();

        itemMapBookings.putIfAbsent(booking.getItemId(), new HashSet<>());
        itemMapBookings.get(booking.getItemId()).add(booking);
        bookingMap.put(booking.getId(), booking);



        return booking;
    }

    @Override
    public String confirmBooking(long itemId, long bookingId, long ownerId)  {

        Item item = repositoryItem.getItemById(itemId);

        if (item.getId() != ownerId) return "ERROR!!!1C";
        Booking booking = bookingMap.get(bookingId);
        if (!itemMapBookings.containsKey(item.getId())
                || !itemMapBookings.get(item.getId()).contains(booking)) return "ERROR!!!2C";

        item.setAvailable(false);
        item.setBooking(booking); // return?

        itemMapBookings.get(item.getId()).remove(booking);

        return "Well done!!!";
    }


}
