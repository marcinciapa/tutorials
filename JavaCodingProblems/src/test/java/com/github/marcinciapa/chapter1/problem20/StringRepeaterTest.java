package com.github.marcinciapa.chapter1.problem20;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class StringRepeaterTest<T extends StringRepeater> {

    protected abstract T createInstance();

    @ParameterizedTest
    @MethodSource("incorrectTestInput")
    void shouldFailOnIncorrectInput(String inputString, int n) {
        T instance = createInstance();
        assertThrows(IllegalArgumentException.class, () ->
                instance.repeatTimes(n, inputString)
        );
    }

    protected static Stream<Arguments> incorrectTestInput() {
        return Stream.of(
                Arguments.of(null, 1),
                Arguments.of("abc", -1),
                Arguments.of(null, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldProvideExpectedValue(String inputString, int n, String expectedResult) {
        // given
        T instance = createInstance();

        // when
        String result = instance.repeatTimes(n, inputString);

        // then
        assertEquals(expectedResult, result);
    }

    protected static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("", 0, ""),
                Arguments.of("", 1, ""),
                Arguments.of("", 3, ""),
                Arguments.of("abc", 0, ""),
                Arguments.of("abc", 1, "abc"),
                Arguments.of("abc", 3, "abcabcabc")
        );
    }
}
