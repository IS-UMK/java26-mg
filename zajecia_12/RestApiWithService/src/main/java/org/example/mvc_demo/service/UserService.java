package org.example.mvc_demo.service;

import org.example.mvc_demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void updateUser(User user);
    void deleteUser(int id);
    void addUser(User user);
    void deleteAllUsers();
}
