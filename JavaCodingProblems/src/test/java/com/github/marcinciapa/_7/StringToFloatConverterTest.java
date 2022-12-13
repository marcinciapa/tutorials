package com.github.marcinciapa._7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

interface StringToFloatConverterTest<T extends StringToFloatConverter> {

    T createConverter();

    @ParameterizedTest
    @NullSource
    @MethodSource("invalidFormatInput")
    default void shouldThrowExceptionWhenIncorrectFormatProvided(String inputString) {
        // given
        T converter = createConverter();

        // then
        assertThrows(InvalidStringFormatException.class, () -> converter.convertToFloat(inputString));
    }

    @ParameterizedTest
    @MethodSource("validFormatInput")
    default void shouldConvertCorrectValue(String inputString, float expectedValue) {
        // given
        T converter = createConverter();

        // when
        float convertedValue = converter.convertToFloat(inputString);

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
                Arguments.of("0", 0f),
                Arguments.of("-1.1", -1.1f),
                Arguments.of("1.1", 1.1f),
                Arguments.of(Float.toString(Float.MAX_VALUE), Float.MAX_VALUE),
                Arguments.of(Float.toString(Float.MIN_VALUE), Float.MIN_VALUE)
        );
    }
}
