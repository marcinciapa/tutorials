package com.github.marcinciapa.chapter1.problem36;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class NextFloatGeneratorTest<T extends NextFloatGenerator> {

    abstract T createInstance();

    @ParameterizedTest
    @ValueSource(floats = {Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE})
    void searchingNextFloatUpFails(float illegalArgument) {
        T generator = createInstance();
        assertThrows(ArithmeticException.class, () -> generator.nextUp(illegalArgument));
    }

    @ParameterizedTest
    @MethodSource("nextUpTestData")
    void shouldReturnNextFloatUp(float previous, float expectedNext) {
        // given
        T generator = createInstance();

        // when
        float next = generator.nextUp(previous);

        // then
        System.out.printf("Comparing %f with expected %f%n", next, expectedNext);
        assertEquals(expectedNext, next);
    }

    static Stream<Arguments> nextUpTestData() {
        return testInputs().map(input -> mapToArguments(input, Math::nextUp));
    }

    @ParameterizedTest
    @ValueSource(floats = {Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE})
    void searchingNextFloatDownFails(float illegalArgument) {
        T generator = createInstance();
        assertThrows(ArithmeticException.class, () -> generator.nextDown(illegalArgument));
    }

    @ParameterizedTest
    @MethodSource("nextDownTestData")
    void shouldReturnNextFloatDown(float previous, float expectedNext) {
        // given
        T generator = createInstance();

        // when
        float next = generator.nextDown(previous);

        // then
        System.out.printf("Comparing %f with expected %f%n", next, expectedNext);
        assertEquals(expectedNext, next);
    }

    static Stream<Arguments> nextDownTestData() {
        return testInputs().map(input -> mapToArguments(input, Math::nextDown));
    }

    private static Stream<Float> testInputs() {
        return Stream.of(0f, 1f, -1f, 0.1f, -0.1f, 12.34f, -12.34f);
    }

    static Arguments mapToArguments(float input, Function<Float, Float> mappingFunction) {
        return Arguments.of(input, mappingFunction.apply(input));
    }
}
