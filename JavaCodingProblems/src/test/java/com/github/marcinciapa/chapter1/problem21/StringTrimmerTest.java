package com.github.marcinciapa.chapter1.problem21;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class StringTrimmerTest<T extends StringTrimmer> {

    protected abstract T createInstance();

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldTrimString(String input, String expectedOutput) {
        // given
        T trimmer = createInstance();

        // when
        String output = trimmer.trim(input);

        // then
        assertEquals(expectedOutput, output);
    }

    protected static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of("   ", ""),
                Arguments.of("\n\t", ""),
                Arguments.of("abc", "abc"),
                Arguments.of("abc abc", "abc abc"),
                Arguments.of("  abc", "abc"),
                Arguments.of("abc  ", "abc"),
                Arguments.of("  abc  ", "abc")
        );
    }

}
