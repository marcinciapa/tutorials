package com.github.marcinciapa.chapter2.problem48;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ImmutableStringsHolderTest {

    @Test
    void sameStringsHaveSameHashCode() {
        // Identical strings have the same hash code, which means they point to the same address in memory
        ImmutableStringsHolder strings = new ImmutableStringsHolder("same", "same");
        assertEquals(strings.getString1().hashCode(), strings.getString2().hashCode());
    }

    @Test
    void stringsAreImmutable() {
        // After string is changed, its hashcode changes, which means the reference points to a new address in memory
        String string1 = "same";
        String string2 = "same";

        string1 = string1.replace('s', 'c');
        assertNotEquals(string1.hashCode(), string2.hashCode());
    }

    @Test
    void charArraysAreNotStoredInStringCachePool() {
        String string1 = "same";
        String string2 = "same";

        ImmutableStringsHolder strings = new ImmutableStringsHolder(string1, string2);

        assertNotEquals(strings.getString1().toCharArray(), strings.getString2().toCharArray());
    }

}
