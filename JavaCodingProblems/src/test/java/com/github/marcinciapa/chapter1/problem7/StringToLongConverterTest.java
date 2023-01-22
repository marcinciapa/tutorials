package com.github.marcinciapa.chapter1.problem7;

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

interface StringToLongConverterTest<T extends StringToLongConverter> {

    T createConverter();

    @ParameterizedTest
    @NullSource
    @MethodSource("invalidFormatInput")
    default void shouldThrowExceptionWhenIncorrectFormatProvided(String inputString) {
        // given
        T converter = createConverter();

        // then
        assertThrows(InvalidStringFormatException.class, () -> converter.convertToLong(inputString));
    }

    @ParameterizedTest
    @MethodSource("validFormatInput")
    default void shouldConvertCorrectValue(String inputString, long expectedValue) {
        // given
        T converter = createConverter();

        // when
        long convertedValue = converter.convertToLong(inputString);

        // then
        assertEquals(expectedValue, convertedValue);
    }

    static Stream<Arguments> invalidFormatInput() {
        BigInteger aboveMaxLongValue = valueOf(Long.MAX_VALUE).add(ONE);
        BigInteger belowMinLongValue = valueOf(Long.MIN_VALUE).subtract(ONE);

        return Stream.of(
                Arguments.of(""),
                Arguments.of("abc"),
                Arguments.of(" "),
                Arguments.of("1.23"),
                Arguments.of(aboveMaxLongValue.toString()),
                Arguments.of(belowMinLongValue.toString())
        );
    }

    static Stream<Arguments> validFormatInput() {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of(Long.toString(Long.MAX_VALUE), Long.MAX_VALUE),
                Arguments.of(Long.toString(Long.MIN_VALUE), Long.MIN_VALUE)
        );
    }
}
