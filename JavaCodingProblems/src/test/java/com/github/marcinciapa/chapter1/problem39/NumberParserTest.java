package com.github.marcinciapa.chapter1.problem39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class NumberParserTest<T extends NumberParser> {

    abstract T createParser();

    @Test
    void mostImportantPositiveTestCase() {
        Assertions.fail();
    }
}