package ru.shareit.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.shareit.booking.Booking;

@Data
@AllArgsConstructor
public class ItemDto {

    private long id;
    private String name;
    private String description;
//    private Booking booking;
    private boolean isAvailable;
    private long countOfBookings;
}
