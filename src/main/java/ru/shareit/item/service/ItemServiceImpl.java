package ru.shareit.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shareit.item.Item;
import ru.shareit.item.ItemDto;
import ru.shareit.item.MapperItem;
import ru.shareit.item.repository.RepositoryItem;
import ru.shareit.user.repository.RepositoryUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService{

    RepositoryItem repositoryItem;
    MapperItem mapperItem;
    RepositoryUser repositoryUser;

    @Autowired
    public ItemServiceImpl(RepositoryItem repositoryItem, MapperItem mapperItem, RepositoryUser repositoryUser) {
        this.repositoryItem = repositoryItem;
        this.mapperItem = mapperItem;
        this.repositoryUser = repositoryUser;
    }


    @Override
    public Collection<ItemDto> searchItem(String text) {

        Collection<Item> items = repositoryItem.getAllItems();
        Collection<ItemDto> results = new HashSet<>();

        for (Item item: items
             ) {
            if ((item.getName().contains(text) || item.getDescription().contains(text))
                    && item.isAvailable()) {
                results.add(mapperItem.toDto(item));
            }
        }

        return results;
    }

    @Override
    public String writeFeedback(String text, long itemId) {
        return repositoryItem.writeFeedback(text, itemId);
    }

    @Override
    public Set<Item> getUserItems(long userId) {
        return repositoryUser.getUsedItems(userId);
    }
}
