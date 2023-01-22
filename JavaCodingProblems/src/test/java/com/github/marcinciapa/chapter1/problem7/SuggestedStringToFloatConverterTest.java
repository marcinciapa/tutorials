package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToFloatConverterTest implements StringToFloatConverterTest<SuggestedStringToFloatConverter> {

    @Override
    public SuggestedStringToFloatConverter createConverter() {
        return new SuggestedStringToFloatConverter();
    }
}
