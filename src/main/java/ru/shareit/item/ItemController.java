package ru.shareit.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shareit.item.repository.RepositoryItem;
import ru.shareit.item.service.ItemService;

import java.util.Collection;

@RestController(value = "/items")
public class ItemController {

    RepositoryItem repositoryItem;
    MapperItem mapperItem;
    ItemService itemService;


    @Autowired
    public ItemController(RepositoryItem repositoryItem, MapperItem mapperItem,
                          ItemService itemService) {
        this.repositoryItem = repositoryItem;
        this.mapperItem = mapperItem;
        this.itemService = itemService;
    }

    @PostMapping
    public Item addItem(@RequestBody ItemDto itemDto, @RequestHeader("X-Later-User-Id") long id) {
        return repositoryItem.addItem(mapperItem.toItem(itemDto, id));
    }

    @PatchMapping(value = "/item/{itemId}")
    public Item modifyItem(@RequestBody ItemDto itemDto,
                           @PathVariable long id) {
        return repositoryItem.modifyItem(itemDto, id);
    }

    @GetMapping(value = "/item/{itemId}")
    public ItemDto getItemById(@PathVariable long itemId) {
        return mapperItem.toDto(repositoryItem.getItemById(itemId));
    }

    @GetMapping(value = "/item")
    public Collection<Item> getItems(@RequestHeader("X-Later-User-Id") long id) {
        return repositoryItem.getItems(id);
    }

    @GetMapping(value = "/search")
    public Collection<ItemDto> search(@RequestParam String text) {
        return itemService.searchItem(text);
    }






}
