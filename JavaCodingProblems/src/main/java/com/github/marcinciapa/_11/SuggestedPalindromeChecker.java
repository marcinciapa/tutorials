package com.github.marcinciapa._11;

import static java.util.Objects.isNull;

class SuggestedPalindromeChecker implements PalindromeChecker {

    @Override
    public boolean isPalindrome(String inputString) {
        if(isNull(inputString)) {
            throw new IllegalArgumentException();
        }
        String reversedString = new StringBuffer(inputString).reverse().toString();
        return inputString.equals(reversedString);
    }
}
