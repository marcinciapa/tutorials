package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;

class UnmodifiableListWrapperTest extends UnmodifiableWrapperTest<UnmodifiableListWrapper<MutableObject>> {

    @Override
    UnmodifiableListWrapper<MutableObject> wrapper(Collection<MutableObject> collection) {
        return new UnmodifiableListWrapper<>(collection);
    }
}
