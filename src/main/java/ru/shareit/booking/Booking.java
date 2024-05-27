package ru.shareit.booking;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.shareit.item.Item;
import ru.shareit.user.User;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Booking {

    private long id;
    private User customer;
    private Item item;
    private LocalDate bookingDateStart;
    private LocalDate bookingDateEnd;
    private boolean isConfirmed;


}
