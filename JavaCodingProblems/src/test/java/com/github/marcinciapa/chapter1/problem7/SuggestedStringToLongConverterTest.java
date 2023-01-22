package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToLongConverterTest implements StringToLongConverterTest<SuggestedStringToLongConverter> {

    @Override
    public SuggestedStringToLongConverter createConverter() {
        return new SuggestedStringToLongConverter();
    }
}
