package com.github.marcinciapa._7;

class SuggestedStringToFloatConverterTest implements StringToFloatConverterTest<SuggestedStringToFloatConverter> {

    @Override
    public SuggestedStringToFloatConverter createConverter() {
        return new SuggestedStringToFloatConverter();
    }
}
