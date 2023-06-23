package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;

class SelfInventedWrapperTest extends UnmodifiableWrapperTest<SelfInventedWrapper<MutableObject>> {

    @Override
    SelfInventedWrapper<MutableObject> wrapper(Collection<MutableObject> collection) {
        return new SelfInventedWrapper<>(collection);
    }
}
