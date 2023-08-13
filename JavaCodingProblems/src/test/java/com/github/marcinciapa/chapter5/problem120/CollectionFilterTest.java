package com.github.marcinciapa.chapter5.problem120;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class CollectionFilterTest {

    @Test
    void shouldFailWhenInitializedWithNull() {
        assertThrows(IllegalArgumentException.class, () -> new CollectionFilter(null));
    }

    @Test
    void shouldFailNullWhitelistPassed() {
        List<Integer> initialList = List.of(1, 2, 3);
        CollectionFilter collectionFilter = new CollectionFilter(initialList);
        assertThrows(IllegalArgumentException.class, () -> collectionFilter.filter(null));
    }

    @Test
    void shouldReturnEmptyListWhenWhitelistEmpty() {
        // given
        List<Integer> initialList = List.of(2, 3, 4);
        List<Integer> whitelist = emptyList();
        CollectionFilter collectionFilter = new CollectionFilter(initialList);

        // when
        List<Integer> result = collectionFilter.filter(whitelist);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenInitialCollectionEmpty() {
        // given
        List<Integer> initialList = emptyList();
        List<Integer> whitelist = List.of(2, 3, 4);
        CollectionFilter collectionFilter = new CollectionFilter(initialList);

        // when
        List<Integer> result = collectionFilter.filter(whitelist);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnSameListWhenInitialCollectionAndWhitelistSame() {
        // given
        List<Integer> initialList = List.of(2, 3, 4);
        List<Integer> whitelist = List.of(2, 3, 4);
        CollectionFilter collectionFilter = new CollectionFilter(initialList);

        // when
        List<Integer> result = collectionFilter.filter(whitelist);

        // then
        assertEquals(initialList, result);
    }

    @Test
    void shouldReturnOnlyElementsFromWhitelist() {
        // given
        List<Integer> initialList = List.of(1, 2, 3, 4);
        List<Integer> whitelist = List.of(2, 3, 4, 5);
        List<Integer> expectedResult = List.of(2, 3, 4);
        CollectionFilter collectionFilter = new CollectionFilter(initialList);

        // when
        List<Integer> result = collectionFilter.filter(whitelist);

        // then
        assertEquals(expectedResult, result);
    }
}
