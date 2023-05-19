package com.github.marcinciapa.chapter4.problem86;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ListCreatorTest<T extends ListCreator> {

    abstract T creator(int... vals);

    @Test
    void shouldCreateList() {
        // given
        var val1 = 1;
        var val2 = 2;
        var val3 = 3;
        // Doesn't compile, as vars is not allowed with compound declarations
        // var val1 = 1, val2 = 2, val3 = 3;
        var expectedResult = List.of(1, 2, 3);

        // when
        List<Integer> result = creator(val1, val2, val3).toList();

        // then
        assertEquals(expectedResult, result);
    }
}
