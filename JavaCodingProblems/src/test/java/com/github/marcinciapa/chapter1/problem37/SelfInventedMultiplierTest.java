package com.github.marcinciapa.chapter1.problem37;

class SelfInventedMultiplierTest extends MultiplierTest<SelfInventedMultiplier> {

    @Override
    SelfInventedMultiplier createInstance() {
        return new SelfInventedMultiplier();
    }
}
