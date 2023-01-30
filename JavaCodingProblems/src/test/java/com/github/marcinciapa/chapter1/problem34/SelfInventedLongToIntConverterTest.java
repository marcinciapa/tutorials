package com.github.marcinciapa.chapter1.problem34;

class SelfInventedLongToIntConverterTest extends LongToIntConverterTest<SelfInventedLongToIntConverter> {

    @Override
    SelfInventedLongToIntConverter createInstance() {
        return new SelfInventedLongToIntConverter();
    }
}
