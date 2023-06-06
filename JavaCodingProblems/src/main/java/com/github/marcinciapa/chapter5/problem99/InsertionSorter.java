package com.github.marcinciapa.chapter5.problem99;

class InsertionSorter implements ArraySorter {

    @Override
    public Integer[] sort(Integer[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                --j;
            }

            array[j+1] = key;

        }


        return array;
    }
}
