package com.github.marcinciapa.chapter2.problem44;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

class SelfInventedCollectionWrapper implements CollectionWrapper {

    private final ArrayList<?> wrappedCollection;

    SelfInventedCollectionWrapper(Collection<?> wrappedCollection) {
        this.wrappedCollection = new ArrayList<>(requireNonNull(wrappedCollection));
    }

    @Override
    public Object get(int index) {
        try {
            return wrappedCollection.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
