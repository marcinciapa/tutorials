package com.github.marcinciapa._7;

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
