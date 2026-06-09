package org.example.mvc_demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {



    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, -4})
    public void testIsPositive(int number) {

        Assertions.assertTrue(number > 0);
    }
}
