package com.github.marcinciapa.chapter5.problem113;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapReplacerTest {

    private static final Map<String, Integer> MAP = Map.of(
            "one", 1,
            "two", 2,
            "three", 1
    );

    private MapReplacer replacer = new MapReplacer(MAP);

    @Nested
    class ReplaceByKeyTest {

        @Test
        void shouldKeepMapUnchangedWhenKeyNotFound() {
            // when
            replacer.replaceByKey("four", 2);

            // then
            assertEquals(MAP, replacer.map());
        }

        @Test
        void shouldReplaceValueByKey() {
            // given
            Map<String, Integer> mapAfter = Map.of(
                    "one", 1,
                    "two", 2,
                    "three", 0
            );

            // when
            replacer.replaceByKey("three", 0);

            // then
            assertEquals(mapAfter, replacer.map());
        }
    }

    @Nested
    class ReplaceByKeyValueTest {

        @Test
        void shouldKeepMapUnchangedWhenKeyNotFound() {
            // when
            replacer.replaceByKeyValue("four", 2, 0);

            // then
            assertEquals(MAP, replacer.map());
        }

        @Test
        void shouldKeepMapUnchangedWhenValueNotFound() {
            // when
            replacer.replaceByKeyValue("three", 3, 0);

            // then
            assertEquals(MAP, replacer.map());
        }

        @Test
        void shouldKeepMapUnchangedWhenKeyValueCombinationNotFound() {
            // when
            replacer.replaceByKeyValue("one", 2, 0);

            // then
            assertEquals(MAP, replacer.map());
        }

        @Test
        void shouldReplaceFromMapByKeyAndValue() {
            // given
            Map<String, Integer> mapAfter = Map.of(
                    "one", 1,
                    "two", 2,
                    "three", 0
            );

            // when
            replacer.replaceByKeyValue("three", 1, 0);

            // then
            assertEquals(mapAfter, replacer.map());
        }
    }

    @Nested
    class ReplaceByValueTest {

        @Test
        void shouldKeepMapUnchangedWhenValueNotFound() {
            // when
            replacer.replaceByValue(3, 0);

            // then
            assertEquals(MAP, replacer.map());
        }

        @Test
        void shouldReplaceFromMapByValue() {
            // given
            Map<String, Integer> mapAfter = Map.of(
                    "one", 0,
                    "two", 2,
                    "three", 0
            );

            // when
            replacer.replaceByValue(1, 0);

            // then
            assertEquals(mapAfter, replacer.map());
        }
    }
}
