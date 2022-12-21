package com.github.marcinciapa._11;

class SelfInventedPalindromeCheckerTest implements PalindromeCheckerTest<SelfInventedPalindromeChecker> {

    @Override
    public SelfInventedPalindromeChecker createInstance() {
        return new SelfInventedPalindromeChecker();
    }
}
