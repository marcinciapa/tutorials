package com.github.marcinciapa.chapter2.problem41;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class NullCheckerTest<T extends NullChecker> {

    abstract T createChecker();

    @Test
    void shouldThrowExceptionOnNullPassed() {
        T nullChecker = createChecker();
        NullPointerException thrown = assertThrows(NullPointerException.class, () ->
                nullChecker.checkNotNull(null)
        );
        assertEquals("Argument cannot be null", thrown.getMessage());
    }

    @Test
    void shouldDoNothingOnNonNullPassed() {
        T nullChecker = createChecker();
        assertDoesNotThrow(() ->
                nullChecker.checkNotNull("Not null")
        );
    }
}
