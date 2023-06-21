package com.github.marcinciapa.chapter5.problem107;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;

import static java.util.Objects.isNull;

class SelfInventedNgeFinder implements NgeFinder {

    @Override
    public Collection<ElementWithNge> ngeIndex(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }

        List<ElementWithNge> ngeForElement = new ArrayList<>();

        for (int i = 0; i < array.length; ++i) {
            ngeForElement.add(
                    new ElementWithNge(
                            array[i],
                            ngeForIndex(i, array)
                    )
            );
        }

        return ngeForElement;
    }

    private OptionalInt ngeForIndex(int index, int[] array) {
        for (int i = index + 1; i < array.length; ++i) {
            if (array[i] > array[index]) {
                return OptionalInt.of(array[i]);
            }
        }
        return OptionalInt.empty();
    }
}
