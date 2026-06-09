package org.example.mvc_demo.service;

import org.example.mvc_demo.model.User;
import org.example.mvc_demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldReturnUserWhenExists() {
        User user = new User(1, "Jan", "a@a.pl");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        User result = userService.findById(1);

        assertThat(result.getName()).isEqualTo("Jan");
    }
}