package com.github.marcinciapa.chapter5.problem118;

import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;

class IteratorOddRemover implements OddRemover {

    @Override
    public void removeOdd(List<Integer> number) {
        if (isNull(number)) {
            throw new IllegalArgumentException();
        }
        Iterator<Integer> iterator = number.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 != 0) {
                iterator.remove();
            }
        }
    }
}
