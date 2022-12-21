package com.github.marcinciapa._10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

interface StringPermutatorTest<T extends StringPermutator> {

    T createPermutator();

    @Test
    default void shouldThrowExceptionWhenNullProvided() {
        T permutator = createPermutator();
        Assertions.assertThrows(NullPointerException.class, () ->
                permutator.generatePermutations(null)
        );
    }

    @ParameterizedTest
    @MethodSource("testInput")
    default void shouldGenerateExpectedPermutations(String inputString, List<String> expectedResult) {
        T permutator = createPermutator();
        assertEquals(expectedResult, permutator.generatePermutations(inputString));
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of("", emptyList()),
                Arguments.of("a", singletonList("a")),
                Arguments.of("ab", List.of("ab", "ba")),
                Arguments.of("aaaaa", singletonList("aaaaa")),
                Arguments.of("abc", List.of("abc", "acb", "bac", "bca", "cab", "cba")),
                Arguments.of("abaa", List.of("aaab", "aaba", "abaa", "baaa")),
                Arguments.of("aabb", List.of("aabb", "abab", "abba", "baab", "baba", "bbaa"))
        );
    }
}
