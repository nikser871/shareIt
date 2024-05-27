package ru.shareit.item.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shareit.item.Item;
import ru.shareit.item.ItemDto;
import ru.shareit.user.repository.RepositoryUser;

import java.util.*;

@Component
public class RepoItemImpl implements RepositoryItem{

    Map<Long, Item> items = new HashMap<>();
    Map<Long, Set<Item>> itemsOwners = new HashMap<>();



    @Override
    public Item addItem(Item item) {
        itemsOwners.get(item.getOwner().getId()).add(item);
        items.put(item.getId(), item);
        return null;
    }

    @Override
    public Item modifyItem(ItemDto itemDto, long itemId) {
        String name = itemDto.getName();
        String description = itemDto.getDescription();
        boolean availability = itemDto.isAvailable();

        if (name != null) items.get(itemId).setName(name);
        if (description != null) items.get(itemId).setDescription(description);
        items.get(itemId).setAvailable(availability);

        return items.get(itemId);

    }

    @Override
    public Item getItemById(long itemId) {
        return items.get(itemId);
    }

    @Override
    public Collection<Item> getItems(long id) {
        return itemsOwners.get(id);
    }

    @Override
    public Collection<Item> getAllItems() {
        Collection<Item> items = new HashSet<>();
        for (Set<Item> a: itemsOwners.values()
             ) {
            items.addAll(a);
        }
        return items;

    }

}
