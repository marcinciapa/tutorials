package com.github.marcinciapa.chapter1.problem18;

import static java.util.Objects.isNull;

class SuggestedAnagramDiscoverer implements AnagramDiscoverer {

    private static final int EXTENDED_ASCII_CHARS = 256;

    @Override
    public boolean areAnagrams(String string1, String string2) {
        if (isNull(string1) || isNull(string2)) {
            throw new IllegalArgumentException();
        }

        int[] charCounts = new int[EXTENDED_ASCII_CHARS];
        char[] charsString1 = string1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] charsString2 = string2.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (charsString1.length != charsString2.length) {
            return false;
        }

        for (int i = 0; i < charsString1.length; ++i) {
            charCounts[charsString1[i]]++;
            charCounts[charsString2[i]]--;
        }

        for(int chCount : charCounts) {
            if(chCount != 0) {
                return false;
            }
        }
        return true;
    }
}
