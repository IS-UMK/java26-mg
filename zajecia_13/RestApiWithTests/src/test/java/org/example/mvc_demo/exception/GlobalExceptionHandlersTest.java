package org.example.mvc_demo.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlersTest {


    private final GlobalExceptionHandlers handler = new GlobalExceptionHandlers();

    @Test
    public void shouldReturnConflictProblemDetailForUserAlreadyExists() {

        ProblemDetail result = handler.handleUserAlreadyExistsException(
                new UserAlreadyExistsException("Pewien tekst")
        );

        assertEquals(HttpStatus.CONFLICT.value(), result.getStatus());
        assertEquals("Pewien tekst", result.getDetail());
    }
}