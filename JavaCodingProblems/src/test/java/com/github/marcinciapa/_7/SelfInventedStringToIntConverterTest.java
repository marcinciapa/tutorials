package com.github.marcinciapa._7;

class SelfInventedStringToIntConverterTest implements StringToIntConverterTest<SelfInventedStringToIntConverter> {
    @Override
    public SelfInventedStringToIntConverter createConverter() {
        return new SelfInventedStringToIntConverter();
    }
}
