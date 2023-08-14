package com.github.marcinciapa.chapter5.problem121;

import java.util.List;

import static java.util.Objects.isNull;

class IteratingOddReplacer implements OddReplacer {

    @Override
    public void replaceOdd(List<Integer> numbers) {
        if(isNull(numbers)) {
            throw new IllegalArgumentException();
        }
        for(int i=0; i<numbers.size(); ++i) {
            if(numbers.get(i) % 2 != 0) {
                numbers.set(i, 0);
            }
        }
    }
}
