package com.github.marcinciapa.chapter4.problem85;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ListCreatorTest<T extends ListCreator> {

    abstract T creator(int[] vals);

    @Test
    void shouldCreateList() {
        // given
        var vals = new int[]{1, 2, 3};
        List<Integer> expectedResult = List.of(1, 2, 3);

        // when
        List<Integer> result = creator(vals).toList();

        // then
        assertEquals(expectedResult, result);
    }
}
