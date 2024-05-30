package ru.shareit.item.service;

import ru.shareit.item.Item;
import ru.shareit.item.ItemDto;

import java.util.Collection;
import java.util.Set;

public interface ItemService {

    Collection<ItemDto> searchItem(String text);
    String writeFeedback(String text, long itemId);

    Set<Item> getUserItems(long userId);
}
