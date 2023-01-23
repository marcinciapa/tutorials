package com.github.marcinciapa.chapter1.problem30;

class SelfInventedUnsignedDividerTest extends UnsignedDividerTest<SelfInventedUnsignedDivider> {

    @Override
    SelfInventedUnsignedDivider createInstance() {
        return new SelfInventedUnsignedDivider();
    }
}
