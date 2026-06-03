package org.example.mvc_demo.controller;
import org.example.mvc_demo.model.User;
import org.example.mvc_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

// ZMIANA: @RequestMapping("/api/") -> @RequestMapping("/api")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // ZMIANA: @GetMapping("/users/") -> @GetMapping("/users")
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    // ZMIANA: @PostMapping("/users/") >  @PostMapping("/users")
    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.addUser(user);
        return "User Created";
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
