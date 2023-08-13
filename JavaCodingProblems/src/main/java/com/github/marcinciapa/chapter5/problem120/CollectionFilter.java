package com.github.marcinciapa.chapter5.problem120;

import java.util.HashSet;
import java.util.List;

import static java.util.Objects.isNull;

class CollectionFilter {

    private final List<Integer> wrappedList;

    CollectionFilter(List<Integer> initialList) {
        if (isNull(initialList)) {
            throw new IllegalArgumentException();
        }
        this.wrappedList = initialList;
    }

    public List<Integer> filter(List<Integer> whitelist) {
        if (isNull(whitelist)) {
            throw new IllegalArgumentException();
        }
        // Checking if element is contained in set is faster than checking in list
        HashSet<Integer> whitelistSet = new HashSet<>(whitelist);
        return wrappedList.stream()
                .filter(whitelistSet::contains)
                .toList();
    }
}
