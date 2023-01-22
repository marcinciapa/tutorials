package com.github.marcinciapa.chapter1.problem24;

class SelfInventedStringTransformerTest extends StringTransformerTest<SelfInventedStringTransformer> {

    @Override
    SelfInventedStringTransformer createInstance() {
        return new SelfInventedStringTransformer();
    }
}
