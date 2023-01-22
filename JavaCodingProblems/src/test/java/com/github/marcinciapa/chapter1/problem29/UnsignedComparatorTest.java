package com.github.marcinciapa.chapter1.problem29;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Integer.signum;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class UnsignedComparatorTest<T extends UnsignedComparator> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldCompareUnsignedNumbers(int int1, int int2, int expectedResultSignum) {
        // given
        T instance = createInstance();

        // when
        int result = instance.compareUnsigned(int1, int2);

        // then
        assertEquals(expectedResultSignum, signum(result));
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                // When comparing integer, all number <0 is greater than any number >=0
                Arguments.of(0, 0, signum(0)),
                Arguments.of(0, 1, signum(-1)),
                Arguments.of(0, -1, signum(-1)),
                Arguments.of(1, 1, signum(0)),
                Arguments.of(1, -1, signum(-1)),
                Arguments.of(1, Integer.MAX_VALUE, signum(-1)),
                Arguments.of(1, Integer.MIN_VALUE, signum(-1)),
                Arguments.of(1, 0, signum(1)),
                Arguments.of(1, 1, signum(0)),
                Arguments.of(-1, Integer.MAX_VALUE, signum(1)),
                Arguments.of(-1, Integer.MIN_VALUE, signum(1)),
                Arguments.of(-1, 0, signum(1)),
                Arguments.of(-1, -1, signum(0)),
                Arguments.of(Integer.MAX_VALUE, 0, signum(1)),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, signum(-1)),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, signum(0)),
                Arguments.of(Integer.MIN_VALUE, 0, signum(1)),
                Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, signum(1)),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, signum(0))

        );
    }


}
