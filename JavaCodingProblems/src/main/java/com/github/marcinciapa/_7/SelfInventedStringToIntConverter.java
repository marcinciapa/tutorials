package com.github.marcinciapa._7;

class SelfInventedStringToIntConverter implements StringToIntConverter {

    @Override
    public int convertToInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new InvalidStringFormatException();
        }
    }
}
