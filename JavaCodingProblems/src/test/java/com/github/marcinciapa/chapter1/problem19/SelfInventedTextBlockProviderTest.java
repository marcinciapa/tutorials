package com.github.marcinciapa.chapter1.problem19;

class SelfInventedTextBlockProviderTest extends TextBlockProviderTest<SelfInventedTextBlockProvider> {

    @Override
    protected SelfInventedTextBlockProvider getInstance() {
        return new SelfInventedTextBlockProvider();
    }
}
