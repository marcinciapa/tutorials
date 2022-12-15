package com.github.marcinciapa._8;

class SelfInventedWhitespaceRemoverTest implements WhitespaceRemoverTest<SelfInventedWhitespaceRemover> {
    @Override

    public SelfInventedWhitespaceRemover createRemover() {
        return new SelfInventedWhitespaceRemover();
    }
}
