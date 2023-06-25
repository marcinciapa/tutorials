package com.github.marcinciapa.chapter5.problem109;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Objects.isNull;

class ArraysAsListWrapper<T> implements UnmodifiableWrapper<T> {

    private final T[] wrapped;

    public ArraysAsListWrapper(Collection<T> collection) {
        if (isNull(collection)) {
            throw new IllegalArgumentException();
        }
        this.wrapped = (T[]) collection.toArray();
    }

    @Override
    public Collection<T> unmodifiable() {
        return Arrays.asList(wrapped);
    }
}
