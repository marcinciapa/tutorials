package com.github.marcinciapa.chapter1.problem27;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class IntParserTest<T extends IntParser> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("incorrectFormatInput")
    void shouldFailWhenFormatIncorrect(String incorrectFormatNumber, int radix) {
        T instance = createInstance();
        assertThrows(NumberFormatException.class, () ->
                instance.parse(incorrectFormatNumber, radix)
        );
    }

    static Stream<Arguments> incorrectFormatInput() {
        return Stream.of(
                Arguments.of(null, Character.MAX_RADIX),
                Arguments.of("", Character.MAX_RADIX),
                Arguments.of("-1", Character.MAX_RADIX),
                Arguments.of("3", 2),
                Arguments.of("a", 10),
                Arguments.of("3", Character.MAX_RADIX + 1),
                Arguments.of("0", Character.MIN_RADIX - 1)
        );
    }

    @ParameterizedTest
    @MethodSource("correctInput")
    void shouldParseIntCorrectly(String number, int radix, int expectedResult) {
        // given
        T instance = createInstance();

        // when
        int result = instance.parse(number, radix);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> correctInput() {
        return Stream.of(
                Arguments.of("1", 2, 1),
                Arguments.of("0", 2, 0),
                Arguments.of("10", 2, 2),
                Arguments.of("11", 2, 3),
                Arguments.of("10", 10, 10),
                Arguments.of("a", 16, 10),
                Arguments.of("27", 10, 27),
                Arguments.of("6", Character.MAX_RADIX, 6)
        );
    }
}
