package com.github.marcinciapa._19;

class SelfInventedTextBlockProviderTest extends TextBlockProviderTest<SelfInventedTextBlockProvider> {

    @Override
    protected SelfInventedTextBlockProvider getInstance() {
        return new SelfInventedTextBlockProvider();
    }
}
