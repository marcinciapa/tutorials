package com.github.marcinciapa.chapter1.problem7;

class SelfInventedStringToLongConverter implements StringToLongConverter {

    @Override
    public long convertToLong(String inputString) {
        try {
            return Long.parseLong(inputString);
        } catch (NumberFormatException e) {
            throw new InvalidStringFormatException();
        }
    }
}
