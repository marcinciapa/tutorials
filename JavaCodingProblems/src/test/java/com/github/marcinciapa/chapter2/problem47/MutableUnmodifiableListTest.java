package com.github.marcinciapa.chapter2.problem47;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MutableUnmodifiableListTest {

    @Test
    void shouldThrowWhenModifyingList() {
        List<Object> unmodifiableList = List.of();

        assertThrows(UnsupportedOperationException.class, () ->
                unmodifiableList.add(new MutableClass(4))
        );
    }

    @Test
    void shouldMutateList() {
        // given
        List<MutableClass> unmodifiableList = List.of(
                new MutableClass(0),
                new MutableClass(1),
                new MutableClass(2)
        );

        // when
        unmodifiableList.get(2).setI(4);

        // then
        List<MutableClass> expectedList = List.of(
                new MutableClass(0),
                new MutableClass(1),
                new MutableClass(4)
        );
        assertEquals(expectedList, unmodifiableList);
    }
}
