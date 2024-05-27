package ru.shareit.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.shareit.booking.Booking;
import ru.shareit.user.User;

@Data
@AllArgsConstructor
public class Item {

    private long id;
    private User owner;
    private String name;
    private String description;
    private boolean isAvailable;
    private Booking booking;
    private long countOfBookings;

}
