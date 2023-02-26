package com.github.marcinciapa.chapter2.problem44;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

class SuggestedCollectionWrapper implements CollectionWrapper {

    private final ArrayList<?> wrappedCollection;

    SuggestedCollectionWrapper(Collection<?> wrappedCollection) {
        this.wrappedCollection = new ArrayList<>(wrappedCollection);
    }

    @Override
    public Object get(int index) {
        try {
            Objects.checkIndex(index, wrappedCollection.size());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return wrappedCollection.get(index);
    }
}
