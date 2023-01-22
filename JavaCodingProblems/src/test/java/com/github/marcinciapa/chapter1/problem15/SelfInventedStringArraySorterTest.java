package com.github.marcinciapa.chapter1.problem15;

class SelfInventedStringArraySorterTest implements StringArraySorterTest<SelfInventedStringArraySorter> {

    @Override
    public SelfInventedStringArraySorter createInstance() {
        return new SelfInventedStringArraySorter();
    }
}
