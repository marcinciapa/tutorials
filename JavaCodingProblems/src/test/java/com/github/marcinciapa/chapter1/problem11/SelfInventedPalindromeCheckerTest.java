package com.github.marcinciapa.chapter1.problem11;

class SelfInventedPalindromeCheckerTest implements PalindromeCheckerTest<SelfInventedPalindromeChecker> {

    @Override
    public SelfInventedPalindromeChecker createInstance() {
        return new SelfInventedPalindromeChecker();
    }
}
