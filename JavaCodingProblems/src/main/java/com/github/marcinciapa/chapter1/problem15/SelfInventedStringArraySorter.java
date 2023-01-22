package com.github.marcinciapa.chapter1.problem15;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class SelfInventedStringArraySorter implements StringArraySorter {

    @Override
    public String[] sortByLength(String[] inputArray) {
        if (isNull(inputArray)) {
            return null;
        }

        return Arrays.stream(inputArray)
                .sorted(new StringPositionalComparator())
                .toArray(String[]::new);
    }

    private static class StringPositionalComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if(bothNull(s1, s2)) {
                return 0;
            }
            int s1Length = nonNull(s1) ? s1.length() : -1;
            int s2Length = nonNull(s2) ? s2.length() : -1;

            if (s1Length != s2Length) {
                return s1Length - s2Length;
            }

            return s1.compareTo(s2);
        }

        private boolean bothNull(String s1, String s2) {
            return isNull(s1) && isNull(s2);
        }
    }

}
