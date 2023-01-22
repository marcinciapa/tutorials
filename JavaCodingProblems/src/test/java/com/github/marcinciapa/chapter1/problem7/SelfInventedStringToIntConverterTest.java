package com.github.marcinciapa.chapter1.problem7;

class SelfInventedStringToIntConverterTest implements StringToIntConverterTest<SelfInventedStringToIntConverter> {
    @Override
    public SelfInventedStringToIntConverter createConverter() {
        return new SelfInventedStringToIntConverter();
    }
}
