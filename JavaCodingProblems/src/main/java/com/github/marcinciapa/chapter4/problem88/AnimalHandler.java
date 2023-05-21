package com.github.marcinciapa.chapter4.problem88;

class AnimalHandler {

    static String listen(boolean isShy) {
        var animal = isShy ? new Cat() : new Dog();
        return animal.voice();
    }
}
