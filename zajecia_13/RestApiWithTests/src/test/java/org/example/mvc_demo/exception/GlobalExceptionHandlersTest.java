package org.example.mvc_demo.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlersTest {


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, -4})
    public void testIsPositive(int number) {
        Assertions.assertTrue(number > 0);
    }

    @Test
    void addTest() {

        GlobalExceptionHandlers globalExceptionHandlers = new GlobalExceptionHandlers();

        int result = globalExceptionHandlers.add(1, 2);
        assertEquals(result,3);
    }
}