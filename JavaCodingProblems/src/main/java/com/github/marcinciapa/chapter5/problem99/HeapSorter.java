package com.github.marcinciapa.chapter5.problem99;

class HeapSorter implements ArraySorter {

    @Override
    public Integer[] sort(Integer[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        int heapSize = array.length;

        for (int i = heapSize; i > 0; --i) {
            heapify(i - 1, heapSize, array);
        }

        while (heapSize > 1) {
            swap(0, --heapSize, array);
            heapify(0, heapSize, array);
        }

        return array;
    }

    private void heapify(int elementIndex, int heapSize, Integer[] array) {
        int greatestElementIndex = elementIndex;
        int leftChildIndex = elementIndex * 2 + 1;
        int rightChildIndex = elementIndex * 2 + 2;

        if (leftChildIndex < heapSize && array[leftChildIndex] > array[greatestElementIndex]) {
            greatestElementIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && array[rightChildIndex] > array[greatestElementIndex]) {
            greatestElementIndex = rightChildIndex;
        }

        if (greatestElementIndex != elementIndex) {
            swap(greatestElementIndex, elementIndex, array);
            heapify(greatestElementIndex, heapSize, array);
        }
    }

    private void swap(int indexX, int indexY, Integer[] array) {
        Integer temp = array[indexX];
        array[indexX] = array[indexY];
        array[indexY] = temp;
    }
}
