package ru.shareit.item.repository;

import ru.shareit.item.Item;
import ru.shareit.item.ItemDto;

import java.util.Collection;
import java.util.Set;

public interface RepositoryItem {

    Item addItem(Item item);
    Item modifyItem(ItemDto itemDto, long itemId);

    Item getItemById(long itemId);
    Collection<Item> getItems(long id);

    Collection<Item> getAllItems();

    String writeFeedback(String text, long itemId);

}
