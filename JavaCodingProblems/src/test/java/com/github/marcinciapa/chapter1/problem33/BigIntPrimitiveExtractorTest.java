package com.github.marcinciapa.chapter1.problem33;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class BigIntPrimitiveExtractorTest<T extends BigIntPrimitiveExtractor> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("convertTestInput")
    void shouldConvertBigIntegerToPrimitive(BigInteger input, int expectedResult) {
        // given
        T extractor = createInstance();

        // when
        int result = extractor.toPrimitive(input);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> convertTestInput() {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(0), 0),
                Arguments.of(BigInteger.valueOf(1), 1),
                Arguments.of(BigInteger.valueOf(-1), -1),
                Arguments.of(BigInteger.valueOf(Integer.MAX_VALUE), Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("failTestInput")
    void shouldFailWhenInputExtendsRange(BigInteger input) {
        T extractor = createInstance();
        assertThrows(ArithmeticException.class, () -> extractor.toPrimitive(input));
    }

    static Stream<Arguments> failTestInput() {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(Integer.MAX_VALUE).add(ONE)),
                Arguments.of(BigInteger.valueOf(Integer.MIN_VALUE).subtract(ONE))
        );
    }

    @NullSource
    void shouldFailWhenInputIsNull() {
        T extractor = createInstance();
        assertThrows(IllegalArgumentException.class, () -> extractor.toPrimitive(null));
    }
}
