package com.github.marcinciapa.chapter1.problem7;

class SelfInventedStringToFloatConverterTest implements StringToFloatConverterTest<SelfInventedStringToFloatConverter> {

    @Override
    public SelfInventedStringToFloatConverter createConverter() {
        return new SelfInventedStringToFloatConverter();
    }
}
