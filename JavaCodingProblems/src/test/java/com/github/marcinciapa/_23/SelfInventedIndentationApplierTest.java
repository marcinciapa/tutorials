package com.github.marcinciapa._23;

class SelfInventedIndentationApplierTest extends IndentationApplierTest<SelfInventedIndentationApplier> {

    @Override
    SelfInventedIndentationApplier createInstance() {
        return new SelfInventedIndentationApplier();
    }
}
