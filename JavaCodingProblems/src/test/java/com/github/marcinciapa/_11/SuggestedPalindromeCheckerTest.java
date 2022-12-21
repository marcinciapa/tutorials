package com.github.marcinciapa._11;

class SuggestedPalindromeCheckerTest implements PalindromeCheckerTest<SuggestedPalindromeChecker> {

    @Override
    public SuggestedPalindromeChecker createInstance() {
        return new SuggestedPalindromeChecker();
    }
}
