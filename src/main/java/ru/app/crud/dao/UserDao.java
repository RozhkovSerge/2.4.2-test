package ru.app.crud.dao;

import ru.app.crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
    void save(User user);
    void remove(User user);
}
