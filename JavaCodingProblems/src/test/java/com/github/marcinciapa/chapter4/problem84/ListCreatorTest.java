package com.github.marcinciapa.chapter4.problem84;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ListCreatorTest<T extends ListCreator> {

    abstract T creator(int val1, int val2, int val3);

    @Test
    void shouldCreateList() {
        // given
        T creator = creator(1, 2, 3);
        var expectedResult = List.of(1, 2, 3);

        // when
        var result = creator.toList();

        // then
        assertEquals(expectedResult, result);
    }
}
