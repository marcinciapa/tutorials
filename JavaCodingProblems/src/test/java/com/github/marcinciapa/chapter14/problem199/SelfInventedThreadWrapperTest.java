package com.github.marcinciapa.chapter14.problem199;

class SelfInventedThreadWrapperTest extends ThreadWrapperTest<SelfInventedThreadWrapper> {

    @Override
    SelfInventedThreadWrapper wrap(Runnable runnable) {
        return new SelfInventedThreadWrapper(runnable);
    }
}
