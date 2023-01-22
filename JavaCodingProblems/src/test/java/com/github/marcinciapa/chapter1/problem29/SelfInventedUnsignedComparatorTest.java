package com.github.marcinciapa.chapter1.problem29;

class SelfInventedUnsignedComparatorTest extends UnsignedComparatorTest<SelfInventedUnsignedComparator> {

    @Override
    SelfInventedUnsignedComparator createInstance() {
        return new SelfInventedUnsignedComparator();
    }
}
