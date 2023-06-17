package com.github.marcinciapa.chapter5.problem103;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

class SelfInventedArrayStreamer implements ArrayStreamer {

    private final int[] array;

    SelfInventedArrayStreamer(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }
        this.array = array;
    }

    @Override
    public Stream<Integer> stream() {
        return Arrays.stream(array).boxed();
    }
}
