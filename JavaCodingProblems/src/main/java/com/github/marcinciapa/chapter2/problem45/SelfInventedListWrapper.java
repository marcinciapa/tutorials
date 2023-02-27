package com.github.marcinciapa.chapter2.problem45;

import java.util.List;

import static java.util.Objects.checkFromToIndex;

class SelfInventedListWrapper implements ListWrapper {

    private final List<?> wrappedList;

    SelfInventedListWrapper(List<?> wrappedList) {
        if (wrappedList == null) {
            throw new NullPointerException();
        }
        this.wrappedList = wrappedList;
    }

    @Override
    public List<?> sublist(int beginIndex, int endIndex) {
        try {
            checkFromToIndex(beginIndex, endIndex, wrappedList.size());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
        return wrappedList.subList(beginIndex, endIndex);
    }
}
