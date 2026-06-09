package org.example.mvc_demo.controller;
import org.example.mvc_demo.exception.NoSuchUserException;
import org.example.mvc_demo.model.User;
import org.example.mvc_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController

@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {

        var user = userService.findById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found:" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        user.setId(null);
        userService.addUser(user);
        return "User Created";
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {

        User user = userService.findById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id);
        }
        userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/users")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }


    @ExceptionHandler(NoSuchUserException.class)
    public ProblemDetail handleNoSuchUserException(NoSuchUserException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("User not found (własny wyjątek)");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;
    }
}
