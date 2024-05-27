package ru.shareit.item_request;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.shareit.user.User;

@Data
@AllArgsConstructor
public class ItemRequest {

    private String name;
    private User user;

}
