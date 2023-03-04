package com.github.marcinciapa.chapter2.problem49;

import java.util.List;

interface ImmutableListWrapper<T extends Copyable> {

    List<T> list();
}
