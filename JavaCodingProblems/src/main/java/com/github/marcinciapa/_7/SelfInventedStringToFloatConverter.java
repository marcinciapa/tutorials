package com.github.marcinciapa._7;

class SelfInventedStringToFloatConverter implements StringToFloatConverter {
    @Override
    public float convertToFloat(String inputString) {
        try {
            return Float.parseFloat(inputString);
        } catch(NumberFormatException | NullPointerException e) {
            throw new InvalidStringFormatException();
        }
    }
}
