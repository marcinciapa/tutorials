package com.github.marcinciapa._10;

class SelfInventedStringPermutatorTest implements StringPermutatorTest<SelfInventedStringPermutator> {

    @Override
    public SelfInventedStringPermutator createPermutator() {
        return new SelfInventedStringPermutator();
    }
}
