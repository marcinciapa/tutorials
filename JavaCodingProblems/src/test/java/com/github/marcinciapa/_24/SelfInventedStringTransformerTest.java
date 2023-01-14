package com.github.marcinciapa._24;

class SelfInventedStringTransformerTest extends StringTransformerTest<SelfInventedStringTransformer> {

    @Override
    SelfInventedStringTransformer createInstance() {
        return new SelfInventedStringTransformer();
    }
}
