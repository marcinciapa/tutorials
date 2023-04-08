package com.github.marcinciapa.chapter3.problem62;

class SelfInventedInstantConverterTest extends InstantConverterTest<SelfInventedInstantConverter> {

    @Override
    SelfInventedInstantConverter converter() {
        return new SelfInventedInstantConverter();
    }
}
