package com.github.marcinciapa._7;

class SuggestedStringToDoubleConverterTest implements StringToDoubleConverterTest<SuggestedStringToDoubleConverter> {

    @Override
    public SuggestedStringToDoubleConverter createConverter() {
        return new SuggestedStringToDoubleConverter();
    }
}
