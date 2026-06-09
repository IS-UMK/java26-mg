package org.example.mvc_demo.service;

import org.example.mvc_demo.model.User;
import org.example.mvc_demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void finalAll_shouldReturnListFromRepository() {
        List<User> expected = List.of(new User(1, "Anna", "anna@example.com"));
        when(userRepository.findAll()).thenReturn(expected);

        List<User> result = userService.findAll();
        assertEquals(expected, result);

        // Verify: upewniamy sie, ze metoda repozytorium została wywolana dokladnie raz
        verify(userRepository, times(1)).findAll();
    }
}