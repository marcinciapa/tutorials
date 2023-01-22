package com.github.marcinciapa.chapter1.problem22;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class CommonPrefixFinderTest<T extends CommonPrefixFinder> {

    protected abstract T createInstance();

    @ParameterizedTest
    @MethodSource("incorrectInput")
    @NullSource
    void shouldThrowExceptionOnIncorrectInput(List<String> incorrectInput) {
        T instance = createInstance();
        assertThrows(IllegalArgumentException.class, () ->
                instance.findCommonPrefix(incorrectInput)
        );
    }

    static Stream<Arguments> incorrectInput() {
        return Stream.of(
                Arguments.of(asList(null, null)),
                Arguments.of(asList("abc", null, "def"))
        );
    }

    @ParameterizedTest
    @MethodSource("correctInput")
    void shouldCountCommonPrefixLengthCorrectly(List<String> testInput, String expectedCommonPrefix) {
        // given
        T instance = createInstance();

        // when
        String commonPrefix = instance.findCommonPrefix(testInput);

        // then
        assertEquals(expectedCommonPrefix, commonPrefix);
    }

    static Stream<Arguments> correctInput() {
        return Stream.of(
                Arguments.of(emptyList(), ""),
                Arguments.of(List.of(""), ""),
                Arguments.of(List.of("abc"), "abc"),
                Arguments.of(List.of("", "", ""), ""),
                Arguments.of(List.of("abc", "abc", ""), ""),
                Arguments.of(List.of("abc", "abc", "abc"), "abc"),
                Arguments.of(List.of("abcdddddd", "abceeeeee", "abcffffff"), "abc"),
                Arguments.of(List.of("abcddddddd", "abceeeeeee", "abcfffffff"), "abc"),
                Arguments.of(List.of("abcdefgddd", "abcdefgeee", "abcdefgfff"), "abcdefg"),
                Arguments.of(List.of("abc", "bbc", "cbc"), "")
        );
    }
}
