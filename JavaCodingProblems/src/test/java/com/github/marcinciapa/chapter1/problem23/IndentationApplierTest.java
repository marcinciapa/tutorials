package com.github.marcinciapa.chapter1.problem23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class IndentationApplierTest<T extends IndentationApplier> {

    abstract T createInstance();

    @Test
    void shouldFailOnIncorrectInput() {
        T instance = createInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                instance.indented(null)
        );
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldApplyIndentation(String input, String expectedOutput) {
        // given
        T instance = createInstance();

        // when
        String indented = instance.indented(input);

        // then
        assertEquals(expectedOutput, indented);
    }

    static Stream<Arguments> testInput() {
        String multiLineString = """
                this
                is
                a
                                
                multiline
                string""";

        String indentedMultilineString = """
                \s\sthis
                \s\sis
                \s\sa
                \s\s
                \s\smultiline
                \s\sstring
                """;

        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("\t", "  \t\n"),
                Arguments.of(" ", "   \n"),
                Arguments.of("\n", "  \n"),
                Arguments.of("string", "  string\n"),
                Arguments.of("line1\nline2", "  line1\n  line2\n"),
                Arguments.of(multiLineString, indentedMultilineString)
        );
    }
}
