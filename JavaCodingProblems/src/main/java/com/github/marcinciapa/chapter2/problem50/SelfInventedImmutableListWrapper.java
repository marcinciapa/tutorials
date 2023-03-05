package com.github.marcinciapa.chapter2.problem50;

import java.util.ArrayList;
import java.util.List;

final class SelfInventedImmutableListWrapper<T extends Copyable> implements ImmutableListWrapper<T>{

    private final List<T> wrappedList;

    SelfInventedImmutableListWrapper(List<T> list) {
        this.wrappedList = new ArrayList<>(list);
    }

    @Override
    public List<T> list() {
        List<Copyable> copyables = wrappedList.stream()
                .map(T::copy)
                .toList();
        return new ArrayList<>((List<T>)copyables);
    }
}
