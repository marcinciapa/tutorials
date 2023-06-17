package com.github.marcinciapa.chapter5.problem103;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

abstract class ArrayStreamerTest<T extends ArrayStreamer> {

    abstract T streamer(int[] array);

    @Test
    void shouldFailWhenInitializedWithNull() {
        assertThrows(IllegalArgumentException.class, () -> streamer(null));
    }

    @Test
    void shouldReturnEmptyStream() {
        // given
        List<Integer> expectedResult = emptyList();
        T streamer = streamer(new int[]{});

        // when
        Stream<Integer> result = streamer.stream();

        // then
        assertEquals(expectedResult, result.toList());
    }

    @Test
    void shouldReturnOneElementStream() {
        // given
        List<Integer> expectedResult = List.of(1);
        T streamer = streamer(new int[]{1});

        // when
        Stream<Integer> result = streamer.stream();

        // then
        assertEquals(expectedResult, result.toList());
    }

    @Test
    void shouldReturnMultiElementStream() {
        // given
        List<Integer> expectedResult = List.of(1, 2, 3);
        T streamer = streamer(new int[]{1, 2, 3});

        // when
        Stream<Integer> result = streamer.stream();

        // then
        assertEquals(expectedResult, result.toList());
    }
}
