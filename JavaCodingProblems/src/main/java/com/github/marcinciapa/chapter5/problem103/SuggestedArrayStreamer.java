package com.github.marcinciapa.chapter5.problem103;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

class SuggestedArrayStreamer implements ArrayStreamer {

    private final int[] array;

    SuggestedArrayStreamer(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }
        this.array = array;
    }

    @Override
    public Stream<Integer> stream() {
        return IntStream.of(array).boxed();
    }
}
