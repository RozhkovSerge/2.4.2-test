package ru.app.crud.service;

import ru.app.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
    void save(User user);
    void remove(User user);

}
