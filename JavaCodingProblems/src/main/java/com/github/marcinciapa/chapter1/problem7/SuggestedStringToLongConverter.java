package com.github.marcinciapa.chapter1.problem7;

class SuggestedStringToLongConverter implements StringToLongConverter {

    private final StringToLongConverter selfInventedConverter = new SelfInventedStringToLongConverter();

    @Override
    public long convertToLong(String inputString) {
        return selfInventedConverter.convertToLong(inputString);
    }
}
