package com.github.marcinciapa.chapter1.problem7;

class SelfInventedStringToDoubleConverterTest implements StringToDoubleConverterTest<SelfInventedStringToDoubleConverter> {

    @Override
    public SelfInventedStringToDoubleConverter createConverter() {
        return new SelfInventedStringToDoubleConverter();
    }
}
