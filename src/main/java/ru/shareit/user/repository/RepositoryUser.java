package ru.shareit.user.repository;

import ru.shareit.user.User;
import ru.shareit.user.UserDto;

import java.util.Collection;
import java.util.Collections;

public interface RepositoryUser {

    User addUser(User user, long id);
    User getUserById(long id);
    void deleteUserById(long id);
    User updateUserById(User user, long id);
    Collection<User> getUsers();
}
