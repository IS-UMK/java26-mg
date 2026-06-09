package org.example.mvc_demo.service;

import org.example.mvc_demo.exception.NoSuchUserException;
import org.example.mvc_demo.exception.UserAlreadyExistsException;
import org.example.mvc_demo.model.User;
import org.example.mvc_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Serwis odpowiedzialny za zarządzanie użytkownikami.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl()
    {
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    /**
     * Zwraca użytkownika na podstawie identyfikatora.
     *
     * @param id identyfikator użytkownika
     * @return znaleziony użytkownik
     * @throws NoSuchElementException gdy użytkownik nie istnieje
     */
    @Override
    public User findById(int id) {

        User user = userRepository.findById(id).orElse(null);
        if(user==null)
        {
            throw new NoSuchUserException("Nie znaleziono usera " + id);
        }
        return user;
    }


    @Override
    public void updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (!existingUser.isPresent()) {
            throw new NoSuchUserException("No Such Customer exists: " + user.getId());
        } else {
            existingUser.get().setName(user.getName());
            userRepository.save(existingUser.get());
        }
    }


    @Override
    public void deleteUser(int id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (!existingUser.isPresent()) {
            throw new NoSuchUserException("No Such User exists: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        Optional<User> existingUser = userRepository.findUsersByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUsersByEmail(email).orElseThrow( () -> new NoSuchUserException("Nie znaleziono usera " + email));
    }
}
