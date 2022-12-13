package com.github.marcinciapa._7;

class SuggestedStringToFloatConverter implements StringToFloatConverter {

    private final StringToFloatConverter selfInventedConverter = new SelfInventedStringToFloatConverter();

    @Override
    public float convertToFloat(String inputString) {
        return selfInventedConverter.convertToFloat(inputString);
    }
}
