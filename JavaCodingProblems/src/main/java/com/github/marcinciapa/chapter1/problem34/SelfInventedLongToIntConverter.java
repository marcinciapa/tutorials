package com.github.marcinciapa.chapter1.problem34;

class SelfInventedLongToIntConverter implements LongToIntConverter {

    @Override
    public int convert(long input) {
        return Math.toIntExact(input);
    }
}
