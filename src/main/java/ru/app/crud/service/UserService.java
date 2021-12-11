package ru.app.crud.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.app.crud.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
    void save(User user);
    void remove(User user);

}
