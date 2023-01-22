package com.github.marcinciapa.chapter1.problem7;

class SelfInventedStringToLongConverterTest implements StringToLongConverterTest<SelfInventedStringToLongConverter>{
    @Override
    public SelfInventedStringToLongConverter createConverter() {
        return new SelfInventedStringToLongConverter();
    }
}
