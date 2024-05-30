package ru.shareit.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import ru.shareit.booking.Booking;
import ru.shareit.user.User;

@Data
@AllArgsConstructor
public class Item {

    private long id;
    private User owner;
    private String name;
    private String description;
    @Value("1")
    private boolean isAvailable;
    private Booking booking;
    private long countOfBookings;

}
