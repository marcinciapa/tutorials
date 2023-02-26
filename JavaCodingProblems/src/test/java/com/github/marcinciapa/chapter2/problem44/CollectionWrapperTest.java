package com.github.marcinciapa.chapter2.problem44;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class CollectionWrapperTest<T extends CollectionWrapper> {

    abstract T wrap(Collection<?> collection);

    @Test
    void shouldThrowNullPointerExceptionWhenWrappingNull() {
        assertThrows(NullPointerException.class, () ->
                wrap(null)
        );
    }

    @ParameterizedTest
    @MethodSource("inRangeIndexTestInput")
    void shouldGetElementWhenIndexInRange(Collection<?> collection, int index, Object expectedResult) {
        // given
        T wrapper = wrap(collection);

        // when
        Object result = wrapper.get(index);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> inRangeIndexTestInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 0, 1),
                Arguments.of(List.of(1, 2, 3), 2, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("outOfRangeIndexTestInput")
    void shouldThrowIllegalArgumentExceptionWhenAccessingOutOfRange(Collection<?> collection, int index) {
        T wrapper = wrap(collection);
        assertThrows(IllegalArgumentException.class, () ->
                wrapper.get(index)
        );
    }

    static Stream<Arguments> outOfRangeIndexTestInput() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(1, 2, 3), -1),
                Arguments.of(List.of(1, 2, 3), 3)
        );
    }
}
