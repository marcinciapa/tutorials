package com.github.marcinciapa.chapter5.problem121;

class IteratingOddReplacerTest extends OddReplacerTest<IteratingOddReplacer>{

    @Override
    IteratingOddReplacer oddReplacer() {
        return new IteratingOddReplacer();
    }
}
