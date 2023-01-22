package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToDoubleConverterTest implements StringToDoubleConverterTest<SuggestedStringToDoubleConverter> {

    @Override
    public SuggestedStringToDoubleConverter createConverter() {
        return new SuggestedStringToDoubleConverter();
    }
}
