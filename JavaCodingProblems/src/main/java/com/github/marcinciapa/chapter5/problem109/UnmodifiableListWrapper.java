package com.github.marcinciapa.chapter5.problem109;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.isNull;

class UnmodifiableListWrapper<T> implements UnmodifiableWrapper<T> {

    private final Collection<T> wrapped;

    UnmodifiableListWrapper(Collection<T> toWrap) {
        if (isNull(toWrap)) {
            throw new IllegalArgumentException();
        }
        this.wrapped = toWrap;
    }

    @Override
    public Collection<T> unmodifiable() {
        return unmodifiableList(new ArrayList<>(wrapped));
    }
}
