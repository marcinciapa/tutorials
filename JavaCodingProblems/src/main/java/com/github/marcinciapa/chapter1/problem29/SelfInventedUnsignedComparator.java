package com.github.marcinciapa.chapter1.problem29;

class SelfInventedUnsignedComparator implements UnsignedComparator {

    @Override
    public int compareUnsigned(int integer1, int integer2) {
        return Integer.compareUnsigned(integer1, integer2);
    }
}
