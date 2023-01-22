package com.github.marcinciapa.chapter1.problem7;

class SelfInventedStringToDoubleConverter implements StringToDoubleConverter {

    @Override
    public double convertToDouble(String inputString) {
        try {
            return Double.parseDouble(inputString);
        } catch (NumberFormatException | NullPointerException e) {
            throw new InvalidStringFormatException();
        }
    }
}
