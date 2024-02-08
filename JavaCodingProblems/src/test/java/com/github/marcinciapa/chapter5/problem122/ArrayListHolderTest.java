package com.github.marcinciapa.chapter5.problem122;

import java.util.List;

class ArrayListHolderTest extends CollectionHolderTest<List<ValueHolder>> {

    @Override
    CollectionHolder<List<ValueHolder>> getHolder() {
        return ArrayListHolder.COLLECTION;
    }
}
