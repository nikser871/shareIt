package ru.shareit.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shareit.item.Item;
import ru.shareit.user.MapperUser;
import ru.shareit.user.User;
import ru.shareit.user.UserDto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RepoUserImpl implements RepositoryUser{
    Map<Long, User> users = new HashMap<>();
    Map<Long, Set<Item>> usedItems = new HashMap<>();

    MapperUser mapperUser;

    @Autowired
    public RepoUserImpl(MapperUser mapperUser) {
        this.mapperUser = mapperUser;
    }

    @Override
    public User addUser(User user, long id) {
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        return users.get(id);
    }

    @Override
    public void deleteUserById(long id) {
        users.remove(id);
    }

    @Override
    public User updateUserById(User user, long id) {
        users.put(id, user);
        return user;
    }

    @Override
    public Collection<User> getUsers() {
        return users.values();
    }

    @Override
    public Set<Item> getUsedItems(long userId) {
        return usedItems.get(userId);
    }
}
