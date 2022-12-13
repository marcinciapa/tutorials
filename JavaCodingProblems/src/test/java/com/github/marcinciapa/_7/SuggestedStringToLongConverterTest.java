package com.github.marcinciapa._7;

class SuggestedStringToLongConverterTest implements StringToLongConverterTest<SuggestedStringToLongConverter> {

    @Override
    public SuggestedStringToLongConverter createConverter() {
        return new SuggestedStringToLongConverter();
    }
}
