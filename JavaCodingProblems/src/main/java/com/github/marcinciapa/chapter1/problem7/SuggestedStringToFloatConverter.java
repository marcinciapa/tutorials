package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToFloatConverter implements StringToFloatConverter {

    private final StringToFloatConverter selfInventedConverter = new SelfInventedStringToFloatConverter();

    @Override
    public float convertToFloat(String inputString) {
        return selfInventedConverter.convertToFloat(inputString);
    }
}
