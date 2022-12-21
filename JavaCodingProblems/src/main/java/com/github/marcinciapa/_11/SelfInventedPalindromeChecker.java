package com.github.marcinciapa._11;

import static java.util.Objects.isNull;

class SelfInventedPalindromeChecker implements PalindromeChecker {

    @Override
    public boolean isPalindrome(String inputString) {
        if(isNull(inputString)) {
            throw new IllegalArgumentException();
        }

        for(int i=0, j=inputString.length()-1; i<=j; ++i, --j) {
            if(inputString.charAt(i) != inputString.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
