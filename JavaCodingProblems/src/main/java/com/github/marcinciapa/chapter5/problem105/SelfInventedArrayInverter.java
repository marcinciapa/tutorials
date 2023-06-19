package com.github.marcinciapa.chapter5.problem105;

import static java.util.Objects.isNull;

class SelfInventedArrayInverter implements ArrayInverter {

    @Override
    public int[] invert(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }
        int arrayLength = array.length;

        int[] invertedArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; ++i) {
            invertedArray[i] = array[arrayLength - i - 1];
        }
        return invertedArray;
    }
}
