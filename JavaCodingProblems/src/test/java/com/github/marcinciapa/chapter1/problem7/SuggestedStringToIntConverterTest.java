package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToIntConverterTest implements StringToIntConverterTest<SuggestedStringToIntConverter> {

    @Override
    public SuggestedStringToIntConverter createConverter() {
        return new SuggestedStringToIntConverter();
    }
}
