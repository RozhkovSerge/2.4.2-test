package ru.app.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.app.crud.model.Role;
import ru.app.crud.model.User;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PopulateDB {
    private UserService userService;

    @Autowired
    public PopulateDB(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void populateDB() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleRepository.saveAll(List.of(roleUser, roleAdmin));
        User user = new User();
        user.setFirstname("Bob");
        user.setLastname("Jhonson");
        user.setEmail("bob@mail.com");
        user.setAge(25);
        user.setPassword("$2a$12$q98.zeMhcdtMh6.EIN/1eO9eJ5RbeU8G1Zl2Bo5zDMUulqYGjH3Pa"); // password is: 100
        user.addRole(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
        user.addRole(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);

        User admin = new User();
        admin.setFirstname("Mike");
        admin.setLastname("Tyson");
        admin.setEmail("mike@mail.com");
        admin.setAge(45);
        admin.setPassword("$2a$12$q98.zeMhcdtMh6.EIN/1eO9eJ5RbeU8G1Zl2Bo5zDMUulqYGjH3Pa"); //password is: 100
        admin.addRole(roleRepository.findByName("ROLE_USER"));
        userRepository.save(admin);

    }
}
