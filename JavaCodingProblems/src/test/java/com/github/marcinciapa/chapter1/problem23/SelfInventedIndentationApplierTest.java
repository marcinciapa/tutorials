package com.github.marcinciapa.chapter1.problem23;

class SelfInventedIndentationApplierTest extends IndentationApplierTest<SelfInventedIndentationApplier> {

    @Override
    SelfInventedIndentationApplier createInstance() {
        return new SelfInventedIndentationApplier();
    }
}
