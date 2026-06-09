package org.example.mvc_demo.integration;

import org.example.mvc_demo.model.User;
import org.example.mvc_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserFlowIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldCreateUser() {
        userService.deleteAllUsers();
        userService.addUser(new User(null, "Jan", "jan@test.pl"));
        User user = userService.findByEmail("jan@test.pl");
        assertThat(user.getId()).isNotNull();
    }
}
