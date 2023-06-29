package com.github.marcinciapa.chapter5.problem110;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.*;

abstract class DefaultExtractorTest<T extends DefaultExtractor> {

    private final int DEFAULT_VALUE = 0;

    abstract T extractor(Map<String, Integer> map);

    @Test
    void shouldFailWhenInitializedWithNull() {
        assertThrows(IllegalArgumentException.class, () -> extractor(null));
    }

    @Test
    void shouldReturnValueIfPresent() {
        // given
        T extractor = extractor(Map.of(
                "1", 1,
                "2", 2,
                "3", 3
        ));

        // when
        int result = extractor.extract("1");

        // then
        assertEquals(1, result);
    }

    @Test
    void shouldReturnDefaultValueIfAbsent() {
        // given
        T extractor = extractor(Map.of(
                "1", 1,
                "2", 2,
                "3", 3
        ));

        // when
        int result = extractor.extract("4");

        // then
        assertEquals(DEFAULT_VALUE, result);
    }

    @Test
    void shouldReturnDefaultValueIfMapEmpty() {
        // given
        T extractor = extractor(emptyMap());

        // when
        int result = extractor.extract("1");

        // then
        assertEquals(DEFAULT_VALUE, result);
    }
}
