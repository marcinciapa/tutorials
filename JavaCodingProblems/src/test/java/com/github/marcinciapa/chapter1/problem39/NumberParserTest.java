package com.github.marcinciapa.chapter1.problem39;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class NumberParserTest<T extends NumberParser> {

    abstract T createParser();

    @ParameterizedTest
    @ValueSource(strings = {"", "abc"})
    @NullSource
    void americanParserShouldFailOnIncorrectInput(String incorrectInput) {
        T parser = createParser();
        assertThrows(IllegalArgumentException.class, () ->
                parser.parseShortAmerican(incorrectInput)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abc"})
    @NullSource
    void italianParserShouldFailOnIncorrectInput(String incorrectInput) {
        T parser = createParser();
        assertThrows(IllegalArgumentException.class, () ->
                parser.parseShortItalian(incorrectInput)
        );
    }

    @ParameterizedTest
    @MethodSource("testInputAmerican")
    void shouldParseAmericanInput(String input, Number expectedOutput) {
        // given
        T parser = createParser();

        // when
        Number output = parser.parseShortAmerican(input);

        // then
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> testInputAmerican() {
        return Stream.of(
                Arguments.of("0", 0L),
                Arguments.of("-1", -1L),
                Arguments.of("432", 432L),
                Arguments.of("-15K", -15_000L),
                Arguments.of("1000K", 1_000_000L),
                Arguments.of("12M", 12_000_000L),
                Arguments.of("2B", 2_000_000_000L)
        );
    }

    @ParameterizedTest
    @MethodSource("testInputItalian")
    void shouldParseItalianInput(String input, Number expectedOutput) {
        // given
        T parser = createParser();

        // when
        Number output = parser.parseShortItalian(input);

        // then
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> testInputItalian() {
        return Stream.of(
                Arguments.of("0", 0L),
                Arguments.of("-1", -1L),
                Arguments.of("432", 432L),
                Arguments.of("-15.000", -15_000L),
                Arguments.of("12 Mln", 12_000_000L),
                Arguments.of("1000 Mln", 1_000_000_000L),
                Arguments.of("2 Mrd", 2_000_000_000L)
        );
    }
}