package com.github.marcinciapa.chapter5.problem119;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class CollectionToArrayConverterTest {

    private final CollectionToArrayConverter converter = new CollectionToArrayConverter();

    @Test
    void shouldFailWhenNullPassed() {
        assertThrows(IllegalArgumentException.class, () -> converter.toArray(null));
    }

    @Test
    void shouldConvertEmptyCollectionToEmptyArray() {
        // when
        String[] result = converter.toArray(emptyList());

        // then
        assertArrayEquals(new String[]{}, result);
    }

    @Test
    void shouldConvertCollectionToArray() {
        // given
        List<String> input = List.of("one", "two", "three");

        // when
        String[] result = converter.toArray(input);

        // then
        assertArrayEquals(new String[]{"one", "two", "three"}, result);
    }
}
