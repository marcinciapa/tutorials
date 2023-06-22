package com.github.marcinciapa.chapter5.problem108;

import static java.util.Objects.isNull;

abstract class ArrayAppenderImpl implements ArrayAppender {

    protected final int[] array;

    ArrayAppenderImpl(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }
        this.array = array;
    }

    @Override
    public int[] append(int... newElements) {
        if (isNull(newElements)) {
            throw new IllegalArgumentException();
        }
        int[] newArray = new int[array.length + newElements.length];
        filledWithOldElements(newArray);
        filledWithNewElements(newArray, newElements);
        return newArray;
    }

    protected abstract void filledWithOldElements(int[] newArray);

    protected abstract void filledWithNewElements(int[] newArray, int[] newElements);
}
