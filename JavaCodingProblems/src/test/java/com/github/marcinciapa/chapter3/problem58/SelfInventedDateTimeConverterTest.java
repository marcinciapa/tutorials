package com.github.marcinciapa.chapter3.problem58;

class SelfInventedDateTimeConverterTest extends DateTimeConverterTest<SelfInventedDateTimeConverter> {

    @Override
    SelfInventedDateTimeConverter createInstance() {
        return new SelfInventedDateTimeConverter();
    }
}
