package com.github.marcinciapa.chapter5.problem118;

class RemoveIfOddRemoverTest extends OddRemoverTest<RemoveIfOddRemover> {

    @Override
    RemoveIfOddRemover oddRemover() {
        return new RemoveIfOddRemover();
    }
}
