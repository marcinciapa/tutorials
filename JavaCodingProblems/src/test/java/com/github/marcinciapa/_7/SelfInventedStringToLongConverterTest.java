package com.github.marcinciapa._7;

class SelfInventedStringToLongConverterTest implements StringToLongConverterTest<SelfInventedStringToLongConverter>{
    @Override
    public SelfInventedStringToLongConverter createConverter() {
        return new SelfInventedStringToLongConverter();
    }
}
