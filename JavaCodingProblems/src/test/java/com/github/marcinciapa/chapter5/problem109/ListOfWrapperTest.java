package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;

class ListOfWrapperTest extends UnmodifiableWrapperTest<ListOfWrapper<MutableObject>> {

    @Override
    ListOfWrapper<MutableObject> wrapper(Collection<MutableObject> collection) {
        return new ListOfWrapper<>(collection);
    }
}
