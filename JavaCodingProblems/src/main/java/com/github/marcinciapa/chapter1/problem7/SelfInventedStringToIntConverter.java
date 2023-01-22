package com.github.marcinciapa.chapter1.problem7;

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
