package com.github.marcinciapa._19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class TextBlockProviderTest<T extends TextBlockProvider> {

    protected abstract T getInstance();

    @Test
    void shouldProvideTextBlock() {
        // given
        T textBlockProvider = getInstance();

        // when
        String textBlock = textBlockProvider.provideTextBlock();

        // then
        assertArrayEquals(new String[]{"This", "is", "a", "multiline", "string"}, textBlock.lines().toArray());
    }
}
