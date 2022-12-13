package com.github.marcinciapa._7;

class SelfInventedStringToFloatConverterTest implements StringToFloatConverterTest<SelfInventedStringToFloatConverter> {

    @Override
    public SelfInventedStringToFloatConverter createConverter() {
        return new SelfInventedStringToFloatConverter();
    }
}
