package ru.shareit.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shareit.item.Item;
import ru.shareit.item.ItemDto;
import ru.shareit.item.MapperItem;
import ru.shareit.item.repository.RepositoryItem;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ItemServiceImpl implements ItemService{

    RepositoryItem repositoryItem;
    MapperItem mapperItem;

    @Autowired
    public ItemServiceImpl(RepositoryItem repositoryItem, MapperItem mapperItem) {
        this.repositoryItem = repositoryItem;
        this.mapperItem = mapperItem;
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
}
