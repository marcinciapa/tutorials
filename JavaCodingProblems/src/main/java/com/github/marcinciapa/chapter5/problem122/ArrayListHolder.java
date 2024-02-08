package com.github.marcinciapa.chapter5.problem122;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

enum ArrayListHolder implements CollectionHolder<List<ValueHolder>> {

//        COLLECTION(new ArrayList<>());  // Throws ConcurrentModificationException
    COLLECTION(new CopyOnWriteArrayList<>());

    private final List<ValueHolder> collection;

    ArrayListHolder(List<ValueHolder> collection) {
        this.collection = collection;
    }

    @Override
    public List<ValueHolder> getCollection() {
        return this.collection;
    }
}
