package org.example.mvc_demo.controller;
import org.example.mvc_demo.model.User;
import org.example.mvc_demo.service.UserService;
import org.example.mvc_demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/users/")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/users/")
    public String createUser(@RequestBody User user) {
         userService.addUser(user);
         return "User Created";
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
       userService.deleteUser(id);
    }

}
