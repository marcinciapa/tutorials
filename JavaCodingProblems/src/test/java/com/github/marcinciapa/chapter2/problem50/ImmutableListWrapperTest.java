package com.github.marcinciapa.chapter2.problem50;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

abstract class ImmutableListWrapperTest<T extends ImmutableListWrapper<MutableTestObject>> {

    abstract T wrap(List<MutableTestObject> list);

    @Test
    void shouldIgnoreListModification() {
        // given
        List<MutableTestObject> listToWrap = List.of(
                new MutableTestObject(0),
                new MutableTestObject(1),
                new MutableTestObject(2)
        );
        T wrappedList = wrap(listToWrap);

        // when
        wrappedList.list().add(new MutableTestObject(3));

        // then
        assertEquals(3, wrappedList.list().size());
    }

    @Test
    void shouldIgnoreListElementsModification() {
        // given
        List<MutableTestObject> listToWrap = List.of(
                new MutableTestObject(0),
                new MutableTestObject(1),
                new MutableTestObject(2)
        );
        T wrappedList = wrap(listToWrap);

        // when
        wrappedList.list().forEach(element -> element.i = element.i + 1);

        // then
        Integer[] integers = wrappedList.list().stream()
                .map(MutableTestObject::getI)
                .toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{0, 1, 2}, integers);
    }
}
