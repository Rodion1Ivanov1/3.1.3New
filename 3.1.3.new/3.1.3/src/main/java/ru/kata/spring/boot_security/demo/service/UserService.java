package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserService {

    User findUserById(Long id);

    List<User> allUser();

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

    void update(User user);



}
