package com.github.marcinciapa.chapter2.problem44;

import java.util.Collection;

class SuggestedCollectionWrapperTest extends CollectionWrapperTest<SuggestedCollectionWrapper> {

    @Override
    SuggestedCollectionWrapper wrap(Collection<?> collection) {
        return new SuggestedCollectionWrapper(collection);
    }
}
