package com.github.marcinciapa._7;

class SuggestedStringToDoubleConverter implements StringToDoubleConverter {

    private final StringToDoubleConverter selfInventedConverter = new SelfInventedStringToDoubleConverter();

    @Override
    public double convertToDouble(String inputString) {
        return selfInventedConverter.convertToDouble(inputString);
    }
}
