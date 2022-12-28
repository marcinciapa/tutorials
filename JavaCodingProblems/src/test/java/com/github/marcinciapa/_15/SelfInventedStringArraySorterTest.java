package com.github.marcinciapa._15;

class SelfInventedStringArraySorterTest implements StringArraySorterTest<SelfInventedStringArraySorter> {

    @Override
    public SelfInventedStringArraySorter createInstance() {
        return new SelfInventedStringArraySorter();
    }
}
