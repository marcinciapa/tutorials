package com.github.marcinciapa.chapter1.problem28;

class SuggestedIntUnsignedConverter implements IntUnsignedConverter {

    @Override
    public long toUnsigned(int integer) {
        return Integer.toUnsignedLong(integer);
    }
}
