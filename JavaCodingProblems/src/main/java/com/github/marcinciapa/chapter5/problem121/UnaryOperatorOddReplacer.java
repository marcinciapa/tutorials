package com.github.marcinciapa.chapter5.problem121;

import java.util.List;

import static java.util.Objects.isNull;

class UnaryOperatorOddReplacer implements OddReplacer {

    @Override
    public void replaceOdd(List<Integer> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException();
        }

        numbers.replaceAll(t -> t % 2 == 0 ? t : 0);
    }
}
