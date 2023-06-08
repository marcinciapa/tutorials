package com.github.marcinciapa.chapter5.problem99;

class CountingSorter implements ArraySorter {

    @Override
    public Integer[] sort(Integer[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (array.length < 2) {
            return array;
        }

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        int[] counts = new int[max - min + 1];

        for (int i = 0; i < array.length; ++i) {
            counts[array[i] - min]++;
        }

        Integer[] result = new Integer[array.length];

        int sortedIndex = 0;
        for (int i = 0; i < counts.length; ++i) {
            while (counts[i] > 0) {
                result[sortedIndex++] = min + i;
                counts[i]--;
            }
        }

        return result;
    }
}
