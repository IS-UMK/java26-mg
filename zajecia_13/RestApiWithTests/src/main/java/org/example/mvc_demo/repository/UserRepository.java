package org.example.mvc_demo.repository;

import org.example.mvc_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUsersByEmail(String email);
}
