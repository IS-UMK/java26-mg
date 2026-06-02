package org.example.mvc_demo.repository;

import org.example.mvc_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User,Integer> {

    User findUsersByEmail(String email);

}
