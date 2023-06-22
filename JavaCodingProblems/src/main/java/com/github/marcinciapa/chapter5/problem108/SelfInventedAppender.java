package com.github.marcinciapa.chapter5.problem108;

class SelfInventedAppender extends ArrayAppenderImpl {

    SelfInventedAppender(int[] array) {
        super(array);
    }

    @Override
    protected void filledWithOldElements(int[] newArray) {
        System.arraycopy(array, 0, newArray, 0, array.length);
    }

    @Override
    protected void filledWithNewElements(int[] newArray, int[] newElements) {
        int appendedIndexStart = array.length;
        System.arraycopy(newElements, 0, newArray, appendedIndexStart, newElements.length);
    }

}
