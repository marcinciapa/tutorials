package com.github.marcinciapa.chapter2.problem55;

import org.junit.jupiter.api.Test;

import static com.github.marcinciapa.chapter2.problem55.Season.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SeasonTranslatorTest {

    @Test
    void shouldTranslateSeason() {
        SeasonTranslator translator = new SeasonTranslator();
        assertEquals("Spring", translator.translate(SPRING));
        assertEquals("Summer", translator.translate(SUMMER));
        assertEquals("Fall", translator.translate(FALL));
        assertEquals("Winter", translator.translate(WINTER));
        assertEquals("unknown", translator.translate(null));
    }
}
