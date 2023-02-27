package com.github.marcinciapa.chapter2.problem45;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ListWrapperTest<T extends ListWrapper> {

    abstract T wrap(List<?> listToWrap);

    @Test
    void shouldThrowNullPointerExceptionWhenWrappingNull() {
        assertThrows(NullPointerException.class, () ->
                wrap(null)
        );

    }

    @ParameterizedTest
    @MethodSource("correctSubrangeTestInput")
    void shouldReturnSublistWhenSubrangeCorrect(List<?> listToWrap,
                                                int subrangeBegin,
                                                int subrangeEnd,
                                                List<?> expectedSublist) {

        // given
        T wrappedList = wrap(listToWrap);

        // when
        List<?> result = wrappedList.sublist(subrangeBegin, subrangeEnd);

        // then
        assertEquals(expectedSublist, result);

    }

    static Stream<Arguments> correctSubrangeTestInput() {
        return Stream.of(
                Arguments.of(List.of(), 0, 0, List.of()),
                Arguments.of(List.of(0), 0, 0, List.of()),
                Arguments.of(List.of(0, 1), 0, 1, List.of(0)),
                Arguments.of(List.of(0, 1), 0, 2, List.of(0, 1)),
                Arguments.of(List.of(0, 1, 2, 3, 4), 0, 0, List.of()),
                Arguments.of(List.of(0, 1, 2, 3, 4), 0, 1, List.of(0)),
                Arguments.of(List.of(0, 1, 2, 3, 4), 3, 4, List.of(3)),
                Arguments.of(List.of(0, 1, 2, 3, 4), 3, 3, List.of()),
                Arguments.of(List.of(0, 1, 2, 3, 4), 1, 3, List.of(1, 2)),
                Arguments.of(List.of(0, 1, 2, 3, 4), 4, 5, List.of(4)),
                Arguments.of(List.of(0, 1, 2, 3, 4), 0, 5, List.of(0, 1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("incorrectSubrangeTestInput")
    void shouldThrowIllegalArgumentWhenSubrangeIncorrect(List<?> listToWrap, int subrangeBegin, int subrangeEnd) {
        T wrappedList = wrap(listToWrap);

        assertThrows(IllegalArgumentException.class, () ->
                wrappedList.sublist(subrangeBegin, subrangeEnd)
        );
    }

    static Stream<Arguments> incorrectSubrangeTestInput() {
        return Stream.of(
                Arguments.of(List.of(), 0, 1),
                Arguments.of(List.of(0), 0, 2),
                Arguments.of(List.of(0, 1, 2, 3, 4), 4, 6),
                Arguments.of(List.of(0, 1, 2, 3, 4), 5, 6),
                Arguments.of(List.of(0, 1, 2, 3, 4), 6, 7),
                Arguments.of(List.of(0, 1, 2, 3, 4), -1, 0),
                Arguments.of(List.of(0, 1, 2, 3, 4), 1, 0),
                Arguments.of(List.of(0, 1, 2, 3, 4), 0, 6)
        );
    }

}
