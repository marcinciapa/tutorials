package com.github.marcinciapa.chapter4.problem88;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalHandlerTest {

    private static final boolean IS_SHY = true;

    @Test
    void shouldHandleCat() {
        // when
        String voice = AnimalHandler.listen(IS_SHY);

        // then
        assertEquals("meow", voice);
    }

    @Test
    void shouldHandleDog() {
        // when
        String voice = AnimalHandler.listen(!IS_SHY);

        // then
        assertEquals("bark", voice);
    }
}
