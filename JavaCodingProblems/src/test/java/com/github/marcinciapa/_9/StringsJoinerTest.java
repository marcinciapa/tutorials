package com.github.marcinciapa._9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

interface StringsJoinerTest<T extends StringsJoiner> {

    T createJoiner();

    @ParameterizedTest
    @MethodSource("incorrectInput")
    default void shouldFailForIncorrectDataInput(String delimiter, String... parts) {
        T joiner = createJoiner();
        assertThrows(IncorrectInputDataException.class, () ->
                joiner.joinWithDelimiter(delimiter, parts)
        );
    }

    @ParameterizedTest
    @MethodSource("correctInput")
    default void shouldJoinParts(String expectedValue, String delimiter, String... parts) {
        T joiner = createJoiner();
        assertEquals(expectedValue, joiner.joinWithDelimiter(delimiter, parts));
    }

    static Stream<Arguments> incorrectInput() {
        return Stream.of(
                Arguments.of(null, new String[]{"a", "b"}),
                Arguments.of(",", new String[]{null, null}),
                Arguments.of(",", new String[]{"a", null}),
                Arguments.of(",", new String[]{null, "b"})
        );
    }

    static Stream<Arguments> correctInput() {
        return Stream.of(
                Arguments.of("a", ",", new String[]{"a", ""}),
                Arguments.of(",,a", ",", new String[]{",", "a"}),
                Arguments.of("b", ",", new String[]{"", "b"}),
                Arguments.of("a,b,c", ",", new String[]{"a", "b", "c"}),
                Arguments.of("a, ,b", ",", new String[]{"a", " ", "b"}),
                Arguments.of("", ",", new String[]{})
        );
    }
}
