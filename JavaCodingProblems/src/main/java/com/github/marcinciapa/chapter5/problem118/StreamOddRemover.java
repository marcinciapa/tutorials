package com.github.marcinciapa.chapter5.problem118;

import java.util.List;

class StreamOddRemover {
    List<Integer> removeOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
    }
}
