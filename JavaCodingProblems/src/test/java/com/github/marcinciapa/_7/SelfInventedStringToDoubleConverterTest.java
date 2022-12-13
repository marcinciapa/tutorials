package com.github.marcinciapa._7;

class SelfInventedStringToDoubleConverterTest implements StringToDoubleConverterTest<SelfInventedStringToDoubleConverter> {

    @Override
    public SelfInventedStringToDoubleConverter createConverter() {
        return new SelfInventedStringToDoubleConverter();
    }
}
