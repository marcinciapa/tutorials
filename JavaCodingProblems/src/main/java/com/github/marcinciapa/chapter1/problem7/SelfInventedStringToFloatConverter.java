package com.github.marcinciapa.chapter1.problem7;

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
