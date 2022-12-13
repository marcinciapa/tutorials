package com.github.marcinciapa._7;

class SuggestedStringToIntConverterTest implements StringToIntConverterTest<SuggestedStringToIntConverter> {

    @Override
    public SuggestedStringToIntConverter createConverter() {
        return new SuggestedStringToIntConverter();
    }
}
