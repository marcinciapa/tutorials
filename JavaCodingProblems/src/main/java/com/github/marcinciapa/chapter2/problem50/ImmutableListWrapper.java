package com.github.marcinciapa.chapter2.problem50;

import java.util.List;

interface ImmutableListWrapper<T extends Copyable> {

    List<T> list();
}
