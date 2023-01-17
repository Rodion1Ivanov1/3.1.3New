package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Component
public class Init {


    private final UserServiceImpl userService;

    @Autowired
    public Init(UserServiceImpl userService) {
        this.userService = userService;
    }




    public  void createUser() {
        User user = new User("user@gmail.com", "100", "user", "userov");
        user.addRole(new Role("ROLE_USER"));
        User admin = new User("admin@gmail.com", "100", "admin", "adminov");
        admin.addRole(new Role("ROLE_ADMIN"));
        userService.saveUser(admin);
        userService.saveUser(user);
    }
}
