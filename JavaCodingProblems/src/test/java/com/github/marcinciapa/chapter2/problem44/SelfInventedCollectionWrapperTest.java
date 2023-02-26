package com.github.marcinciapa.chapter2.problem44;

import java.util.Collection;

class SelfInventedCollectionWrapperTest extends CollectionWrapperTest<SelfInventedCollectionWrapper> {

    @Override
    SelfInventedCollectionWrapper wrap(Collection<?> collection) {
        return new SelfInventedCollectionWrapper(collection);
    }
}
