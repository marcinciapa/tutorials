package com.github.marcinciapa.chapter1.problem11;

class SuggestedPalindromeCheckerTest implements PalindromeCheckerTest<SuggestedPalindromeChecker> {

    @Override
    public SuggestedPalindromeChecker createInstance() {
        return new SuggestedPalindromeChecker();
    }
}
