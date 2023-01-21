package com.github.marcinciapa._28;

class SuggestedIntUnsignedConverter implements IntUnsignedConverter {

    @Override
    public long toUnsigned(int integer) {
        return Integer.toUnsignedLong(integer);
    }
}
