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

        // userService.deleteUser(id);
    }

    @ExceptionHandler(NoSuchUserException.class)
    public ProblemDetail NoSuchUserExceptionHandler(NoSuchUserException ex)
    {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, "User not found");

        return detail;
    }



}
