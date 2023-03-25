package com.github.marcinciapa.chapter2.problem56;

import org.junit.jupiter.api.Test;

import static com.github.marcinciapa.chapter2.problem56.Season.*;
import static org.junit.jupiter.api.Assertions.*;

class SeasonsClassifierTest {

    @Test
    void shouldClassifySeasons() {
        SeasonsClassifier classifier = new SeasonsClassifier();

        assertTrue(classifier.isWarmAndPretty(SPRING));
        assertTrue(classifier.isWarmAndPretty(SUMMER));
        assertFalse(classifier.isWarmAndPretty(FALL));
        assertFalse(classifier.isWarmAndPretty(WINTER));
    }

    @Test
    void shouldThrowIllegalArgument() {
        SeasonsClassifier classifier = new SeasonsClassifier();
        assertThrows(IllegalArgumentException.class, () ->
                classifier.isWarmAndPretty(null)
        );
    }
}
