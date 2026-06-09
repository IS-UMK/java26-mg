package org.example.mvc_demo.repository;

import org.example.mvc_demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/*
    @DataJpaTest wymaga dodania zaleznosci: spring-boot-starter-data-jpa-test<

    <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa-test</artifactId>
    <scope>test</scope>
   </dependency>
 */

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserByEmail() {

        User user = new User();
        user.setName("Jan");
        user.setEmail("jan@test.pl");
        userRepository.save(user);

        Optional<User> result = userRepository.findUsersByEmail("jan@test.pl");

        assertThat(result).isPresent();
    }
}
