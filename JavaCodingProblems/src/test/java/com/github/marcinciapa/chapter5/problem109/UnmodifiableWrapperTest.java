package com.github.marcinciapa.chapter5.problem109;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// TODO replace Integer with mutable object
abstract class UnmodifiableWrapperTest<T extends UnmodifiableWrapper<MutableObject>> {

    abstract T wrapper(Collection<MutableObject> collection);

    @Test
    void shouldFailWhenInitializedWithNull() {
        assertThrows(IllegalArgumentException.class, () -> wrapper(null));
    }

    @Test
    void shouldWrapNonEmptyCollection() {
        // given
        var collectionToWrap = new ArrayList<>(of(
                new MutableObject(1),
                new MutableObject(2),
                new MutableObject(3)
        ));
        var collectionAfterMutation = new ArrayList<>(of(
                new MutableObject(4),
                new MutableObject(2),
                new MutableObject(3)
        ));

        // when
        T wrapper = wrapper(collectionToWrap);
        Collection<MutableObject> wrapped = wrapper.unmodifiable();

        // then
        assertEquals(collectionToWrap, wrapped);
        assertThrows(UnsupportedOperationException.class, () -> wrapped.add(new MutableObject(4)));
        wrapped.iterator().next().value = 4;
        assertEquals(collectionAfterMutation, wrapped);
    }
}
