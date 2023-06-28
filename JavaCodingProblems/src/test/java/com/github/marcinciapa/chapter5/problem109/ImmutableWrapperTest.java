package com.github.marcinciapa.chapter5.problem109;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ImmutableWrapperTest<T extends UnmodifiableWrapper<ImmutableObject>> {

    abstract T wrapper(Collection<ImmutableObject> collection);

    @Test
    void shouldFailWhenInitializedWithNull() {
        assertThrows(IllegalArgumentException.class, () -> wrapper(null));
    }

    @Test
    void shouldWrapNonEmptyCollection() {
        // given
        var collectionToWrap = new ArrayList<>(of(
                new ImmutableObject(1),
                new ImmutableObject(2),
                new ImmutableObject(3)
        ));

        // when
        T wrapper = wrapper(collectionToWrap);
        Collection<ImmutableObject> wrapped = wrapper.unmodifiable();

        // then
        assertEquals(collectionToWrap, wrapped);
        assertThrows(UnsupportedOperationException.class, () -> wrapped.add(new ImmutableObject(4)));
        // wrapped.iterator().next().value = 4; OBJECT IS IMMUTABLE!
    }
}
