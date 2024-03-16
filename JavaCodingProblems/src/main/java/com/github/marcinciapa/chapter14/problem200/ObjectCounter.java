package com.github.marcinciapa.chapter14.problem200;

class ObjectCounter {

    private int counter = 0;

    void increment() {
        synchronized (this) {
            counter++;
        }
    }

    int value() {
        return counter;
    }
}
