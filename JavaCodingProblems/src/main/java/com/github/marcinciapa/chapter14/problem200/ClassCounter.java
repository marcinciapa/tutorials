package com.github.marcinciapa.chapter14.problem200;

class ClassCounter {

    private static int counter = 0;

    static void increment() {
        synchronized (ClassCounter.class) {
            counter++;
        }
    }

    static int value() {
        return counter;
    }
}
