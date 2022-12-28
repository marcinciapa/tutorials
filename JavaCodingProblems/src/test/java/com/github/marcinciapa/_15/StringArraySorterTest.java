package com.github.marcinciapa._15;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

interface StringArraySorterTest<T extends StringArraySorter> {

    T createInstance();

    @ParameterizedTest
    @MethodSource("testParams")
    default void shouldTestStringArrayByLength(String[] input, String[] expectedOutput) {
        T sorter = createInstance();
        assertArrayEquals(expectedOutput, sorter.sortByLength(input));
    }

    static Stream<Arguments> testParams() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new String[]{}, new String[]{}),
                Arguments.of(new String[]{""}, new String[]{""}),
                Arguments.of(new String[]{null}, new String[]{null}),
                Arguments.of(new String[]{null, null}, new String[]{null, null}),
                Arguments.of(new String[]{"abc", "", null}, new String[]{null, "", "abc"}),
                Arguments.of(new String[]{"dce", "abc"}, new String[]{"abc", "dce"}),
                Arguments.of(new String[]{"abc", "def"}, new String[]{"abc", "def"}),
                Arguments.of(new String[]{"def", "bc", "a"}, new String[]{"a", "bc", "def"})
        );
    }
}
