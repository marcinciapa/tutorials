package com.github.marcinciapa.chapter2.problem49;

import java.util.List;

class SelfInventedImmutableListWrapperTest extends
        ImmutableListWrapperTest<SelfInventedImmutableListWrapper<MutableTestObject>> {

    @Override
    SelfInventedImmutableListWrapper<MutableTestObject> wrap(List<MutableTestObject> list) {
        return new SelfInventedImmutableListWrapper<>(list);
    }
}
