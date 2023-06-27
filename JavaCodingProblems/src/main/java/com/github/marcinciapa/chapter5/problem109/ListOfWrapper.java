package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;

class ListOfWrapper<T> implements UnmodifiableWrapper<T> {

    private final Collection<T> wrapped;

    ListOfWrapper(Collection<T> wrapped) {
        if(isNull(wrapped)) {
            throw new IllegalArgumentException();
        }
        this.wrapped = wrapped;
    }

    @Override
    public Collection<T> unmodifiable() {
        return (Collection<T>) List.of(wrapped.toArray(new Object[]{}));
    }
}
