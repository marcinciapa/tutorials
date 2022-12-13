package com.github.marcinciapa._7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

interface StringToDoubleConverterTest<T extends StringToDoubleConverter> {

    T createConverter();

    @ParameterizedTest
    @NullSource
    @MethodSource("invalidFormatInput")
    default void shouldThrowExceptionWhenIncorrectFormatProvided(String inputString) {
        // given
        T converter = createConverter();

        // then
        assertThrows(InvalidStringFormatException.class, () -> converter.convertToDouble(inputString));
    }

    @ParameterizedTest
    @MethodSource("validFormatInput")
    default void shouldConvertCorrectValue(String inputString, double expectedValue) {
        // given
        T converter = createConverter();

        // when
        double convertedValue = converter.convertToDouble(inputString);

        // then
        assertEquals(expectedValue, convertedValue);
    }

    static Stream<Arguments> invalidFormatInput() {
//        BigDecimal aboveMaxFloatValue = valueOf(Float.MAX_VALUE).add(ONE);
//        BigDecimal belowMinFloatValue = valueOf(Float.MIN_VALUE).subtract(ONE);

        return Stream.of(
                Arguments.of(""),
                Arguments.of("abc"),
                Arguments.of(" ")/*,
                Arguments.of(aboveMaxFloatValue.toString()),
                Arguments.of(belowMinFloatValue.toString())*/
        );
    }

    static Stream<Arguments> validFormatInput() {
        return Stream.of(
                Arguments.of("0", 0d),
                Arguments.of("-1.1", -1.1d),
                Arguments.of("1.1", 1.1d),
                Arguments.of(Double.toString(Double.MAX_VALUE), Double.MAX_VALUE),
                Arguments.of(Double.toString(Double.MIN_VALUE), Double.MIN_VALUE)
        );
    }
}
