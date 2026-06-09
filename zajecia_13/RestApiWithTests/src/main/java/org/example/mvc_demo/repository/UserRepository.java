package org.example.mvc_demo.repository;

import org.example.mvc_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Adnotacja @Repository tu nie jest obowiazkowa bo wystsarczy dziedziczenie po interfejsei JpaRepo
@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUsersByEmail(String email);
}
