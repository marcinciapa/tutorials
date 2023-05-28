package com.github.marcinciapa.chapter4.problem96;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

    @Test
    void shouldAddNumbers() throws InitException {
        // given
        // var calculator;          // NOT COMPILING
        // var calculator = null;   // NOT COMPILING
        var calculator = new Calculator(3, 8);
        var expectedResult = 11;

        // when
        var result = calculator.sum();

        // then
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("incorrectValues")
    void shouldThrowInitException(Integer number1, Integer number2) {
        try {
            new Calculator(number1, number2);
            fail("Exception not thrown");
        // } catch(var e) {         // NOT COMPILING
        } catch (InitException e) {
            assertEquals("Numbers cannot be null", e.getMessage());
        }
    }

    static Stream<Arguments> incorrectValues() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(0, null),
                Arguments.of(null, 0)
        );
    }
}
