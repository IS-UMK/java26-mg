package org.example.mvc_demo.service;

import org.example.mvc_demo.model.User;
import org.example.mvc_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users = new ArrayList<User>();

    //@Autowired
    //private UserRepository userRepository;

    public UserServiceImpl()
    {
        users.add(new User(1, "Marek", "abc@abc.ab"));
        users.add(new User(2, "Janek", "abcd@a.b"));
        users.add(new User(3, "Ala", "zzz@aaa.dd"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
    }
}
