package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToDoubleConverter implements StringToDoubleConverter {

    private final StringToDoubleConverter selfInventedConverter = new SelfInventedStringToDoubleConverter();

    @Override
    public double convertToDouble(String inputString) {
        return selfInventedConverter.convertToDouble(inputString);
    }
}
