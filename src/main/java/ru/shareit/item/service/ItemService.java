package ru.shareit.item.service;

import ru.shareit.item.ItemDto;

import java.util.Collection;

public interface ItemService {

    Collection<ItemDto> searchItem(String text);
}
