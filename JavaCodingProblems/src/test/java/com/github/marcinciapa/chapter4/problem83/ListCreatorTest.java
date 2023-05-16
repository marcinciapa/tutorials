package com.github.marcinciapa.chapter4.problem83;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ListCreatorTest<T extends ListCreator> {

    abstract T creator(int val0, int val1, int val2);

    @Test
    void shouldCreateList() {
        // given
        var expectedResult = List.of(1, 2, 3);

        // when
        List<Integer> result = creator(1, 2, 3).toList();

        // then
        assertEquals(expectedResult, result);
    }
}
