package com.github.marcinciapa._7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

interface StringToIntConverterTest<T extends StringToIntConverter> {

    T createConverter();

    @ParameterizedTest
    @NullSource
    @MethodSource("invalidFormatInput")
    default void shouldThrowExceptionWhenIncorrectFormatProvided(String inputString) {
        // given
        T converter = createConverter();

        // then
        assertThrows(InvalidStringFormatException.class, () -> converter.convertToInt(inputString));
    }

    @ParameterizedTest
    @MethodSource("validFormatInput")
    default void shouldConvertCorrectValue(String inputString, int expectedValue) {
        // given
        T converter = createConverter();

        // when
        int convertedValue = converter.convertToInt(inputString);

        // then
        assertEquals(expectedValue, convertedValue);
    }

    static Stream<Arguments> invalidFormatInput() {
        BigInteger aboveMaxIntValue = valueOf(Integer.MAX_VALUE).add(ONE);
        BigInteger belowMinIntValue = valueOf(Integer.MIN_VALUE).subtract(ONE);

        return Stream.of(
                Arguments.of(""),
                Arguments.of("abc"),
                Arguments.of(" "),
                Arguments.of("1.23"),
                Arguments.of(aboveMaxIntValue.toString()),
                Arguments.of(belowMinIntValue.toString())
        );
    }

    static Stream<Arguments> validFormatInput() {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of(Integer.toString(Integer.MAX_VALUE), Integer.MAX_VALUE),
                Arguments.of(Integer.toString(Integer.MIN_VALUE), Integer.MIN_VALUE)
        );
    }
}
