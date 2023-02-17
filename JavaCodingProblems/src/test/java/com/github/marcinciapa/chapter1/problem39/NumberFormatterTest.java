package com.github.marcinciapa.chapter1.problem39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class NumberFormatterTest<T extends NumberFormatter> {

    abstract T createFormatter();

    @ParameterizedTest
    @MethodSource("testInputAmerican")
    void shouldFormatShortAmerican(Long number, String expectedResult) {
        // given
        T formatter = createFormatter();

        // when
        String result = formatter.formatShortAmerican(number);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInputAmerican() {
        return Stream.of(
                Arguments.of(0L, "0"),
                Arguments.of(345L, "345"),
                Arguments.of(-453L, "-453"),
                Arguments.of(1_000L, "1K"),
                Arguments.of(2_003L, "3K"),
                Arguments.of(3_000_000L, "3M"),
                Arguments.of(-3_200_000L, "-4M"),
                Arguments.of(3_200_001L, "4M"),
                Arguments.of(4_000_000_001L, "5B")
        );
    }

    @ParameterizedTest
    @MethodSource("testInputItalian")
    void shouldFormatShortItalian(Long number, String expectedResult) {
        // given
        T formatter = createFormatter();

        // when
        String result = formatter.formatShortItalian(number);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInputItalian() {
        return Stream.of(
                Arguments.of(0L, "0"),
                Arguments.of(345L, "345"),
                Arguments.of(-453L, "-453"),
                Arguments.of(1_000L, "1.000"),
                Arguments.of(2_003L, "2.003"),
                Arguments.of(3_000_000L, "3 Mln"),
                Arguments.of(-3_200_000L, "-4 Mln"),
                Arguments.of(3_200_001L, "4 Mln"),
                Arguments.of(4_000_000_001L, "5 Mrd")
        );
    }
}
