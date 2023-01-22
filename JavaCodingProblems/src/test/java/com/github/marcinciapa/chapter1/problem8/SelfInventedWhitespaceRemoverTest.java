package com.github.marcinciapa.chapter1.problem8;

class SelfInventedWhitespaceRemoverTest implements WhitespaceRemoverTest<SelfInventedWhitespaceRemover> {
    @Override

    public SelfInventedWhitespaceRemover createRemover() {
        return new SelfInventedWhitespaceRemover();
    }
}
