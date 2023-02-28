package com.github.marcinciapa.chapter2.problem46;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void shouldNotRelyOnEqualsWhenSearchingBuckets() {
        HashSet<AlwaysSameHashCodeAlwaysUnequal> hashSet = new HashSet<>();
        AlwaysSameHashCodeAlwaysUnequal object1 = new AlwaysSameHashCodeAlwaysUnequal();
        AlwaysSameHashCodeAlwaysUnequal object2 = new AlwaysSameHashCodeAlwaysUnequal();
        hashSet.add(object1);
        hashSet.add(object1);
        hashSet.add(object2);
        hashSet.add(object2);

        // buckets members compared using reference, not equals:
        assertEquals(2, hashSet.size());
        assertTrue(hashSet.contains(object1));
        assertTrue(hashSet.contains(object2));

        assertFalse(hashSet.contains(new AlwaysSameHashCodeAlwaysUnequal()));
    }
}
