package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;

class ArraysAsListWrapperTest extends UnmodifiableWrapperTest<ArraysAsListWrapper<MutableObject>> {

    @Override
    ArraysAsListWrapper<MutableObject> wrapper(Collection<MutableObject> collection) {
        return new ArraysAsListWrapper<>(collection);
    }
}
