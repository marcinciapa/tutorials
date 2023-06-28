package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;

class ImmutableListOfWrapperTest extends ImmutableWrapperTest<ListOfWrapper<ImmutableObject>> {

    @Override
    ListOfWrapper<ImmutableObject> wrapper(Collection<ImmutableObject> collection) {
        return new ListOfWrapper<>(collection);
    }
}
