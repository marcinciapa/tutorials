package com.github.marcinciapa._7;

class SuggestedStringToIntConverter implements StringToIntConverter {

    private final StringToIntConverter selfInventedConverter = new SelfInventedStringToIntConverter();

    @Override
    public int convertToInt(String inputString) {
        return selfInventedConverter.convertToInt(inputString);
    }
}
