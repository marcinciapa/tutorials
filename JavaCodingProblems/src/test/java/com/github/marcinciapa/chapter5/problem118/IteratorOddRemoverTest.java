package com.github.marcinciapa.chapter5.problem118;

class IteratorOddRemoverTest extends OddRemoverTest<IteratorOddRemover> {

    @Override
    IteratorOddRemover oddRemover() {
        return new IteratorOddRemover();
    }
}
