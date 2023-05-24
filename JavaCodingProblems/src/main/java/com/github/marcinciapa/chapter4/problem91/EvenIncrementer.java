package com.github.marcinciapa.chapter4.problem91;

import java.util.ArrayList;
import java.util.List;

class EvenIncrementer {

    private final List<Integer> numbers;

    EvenIncrementer(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    List<Integer> incrementEven() {
        var even = numbers.stream()
                .filter(number -> number % 2 == 0);
        return even
                .map(number -> ++number)
                .toList();
    }
}
