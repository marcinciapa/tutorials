package com.github.marcinciapa.chapter1.problem10;

class SelfInventedStringPermutatorTest implements StringPermutatorTest<SelfInventedStringPermutator> {

    @Override
    public SelfInventedStringPermutator createPermutator() {
        return new SelfInventedStringPermutator();
    }
}
