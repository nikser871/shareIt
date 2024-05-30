package ru.shareit.booking;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import ru.shareit.item.Item;
import ru.shareit.user.User;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Booking {

    @Nullable // ????
    private long id;
    private long itemId;

    private User customer;
    private Item item;
    private LocalDate bookingDateStart;
    private LocalDate bookingDateEnd;
    @Value("0") // ???????????
    private boolean isConfirmed;


}
