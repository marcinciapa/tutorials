package com.github.marcinciapa.chapter5.problem112;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MapRemoverTest {

    private Map<Integer, String> map = Map.of(
            1, "odd",
            2, "even",
            3, "odd",
            4, "even",
            5, "odd"
    );

    private MapRemover remover = new MapRemover(map);

    @Nested
    class RemoveByKeyTest {

        @Test
        void shouldKeepMapUnchangedWhenKeyNotFound() {
            // when
            remover.removeByKey(6);

            // then
            assertEquals(map, remover.map());
        }

        @Test
        void shouldRemoveFromMapByKey() {
            // given
            Map<Integer, String> mapAfter = Map.of(
                    1, "odd",
                    2, "even",
                    3, "odd",
                    4, "even"
            );

            // when
            remover.removeByKey(5);

            // then
            assertEquals(mapAfter, remover.map());
        }

        @Test
        void shouldFailWhenArgumentNull() {
            assertThrows(IllegalArgumentException.class, () -> remover.removeByKey(null));
        }
    }

    @Nested
    class RemoveByKeyValueTest {

        @Test
        void shouldKeepMapUnchangedWhenKeyNotFound() {
            // when
            remover.removeByKeyValue(6, "even");

            // then
            assertEquals(map, remover.map());
        }

        @Test
        void shouldKeepMapUnchangedWhenValueNotFound() {
            // when
            remover.removeByKeyValue(1, "not even");

            // then
            assertEquals(map, remover.map());
        }

        @Test
        void shouldKeepMapUnchangedWhenKeyValueCombinationNotExists() {
            // when
            remover.removeByKeyValue(1, "even");

            // then
            assertEquals(map, remover.map());
        }

        @Test
        void shouldRemoveFromMapByKeyAndValue() {
            // given
            Map<Integer, String> mapAfter = Map.of(
                    1, "odd",
                    2, "even",
                    3, "odd",
                    4, "even"
            );

            // when
            remover.removeByKeyValue(5, "odd");

            // then
            assertEquals(mapAfter, remover.map());
        }

        @Test
        void shouldFailWhenKeyNull() {
            assertThrows(IllegalArgumentException.class, () -> remover.removeByKeyValue(null, ""));
        }

        @Test
        void shouldFailWhenValueNull() {
            assertThrows(IllegalArgumentException.class, () -> remover.removeByKeyValue(0, null));
        }
    }

    @Nested
    class RemoveByValueTest {

        @Test
        void shouldKeepMapUnchangedWhenValueNotFound() {
            // when
            remover.removeByValue("not even");

            // then
            assertEquals(map, remover.map());
        }

        @Test
        void shouldRemoveFromMapByValue() {
            // given
            Map<Integer, String> mapAfter = Map.of(
                    2, "even",
                    4, "even"
            );

            // when
            remover.removeByValue("odd");

            // then
            assertEquals(mapAfter, remover.map());
        }

        @Test
        void shouldFailWhenArgumentNull() {
            assertThrows(IllegalArgumentException.class, () -> remover.removeByValue(null));
        }
    }
}
