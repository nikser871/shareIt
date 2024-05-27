package ru.shareit.item_request.repository;

import ru.shareit.item.Item;
import ru.shareit.item_request.ItemRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepoItemRequestImpl implements RepositoryItemRequest {

    public Map<Long, Set<ItemRequest>> requests = new HashMap<>();


}
