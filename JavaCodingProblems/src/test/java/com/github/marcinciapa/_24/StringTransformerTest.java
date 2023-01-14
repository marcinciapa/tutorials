package com.github.marcinciapa._24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class StringTransformerTest<T extends StringTransformer> {

    abstract T createInstance();

    @Test
    void shouldFailWhenInvokedWithNull() {
        T instance = createInstance();
        assertThrows(IllegalArgumentException.class, () ->
                instance.upperCaseRepeatedWithoutWhitespaces(null)
        );
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldTransformString(String inputString, String expectedOutputString) {
        // given
        T instance = createInstance();

        // when
        String outputString = instance.upperCaseRepeatedWithoutWhitespaces(inputString);

        // then
        assertEquals(expectedOutputString, outputString);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(" ", ""),
                Arguments.of("abc", "ABCABC"),
                Arguments.of("ABC", "ABCABC"),
                Arguments.of("aBc", "ABCABC"),
                Arguments.of("abc abc\t", "ABCABCABCABC")
        );
    }
}
