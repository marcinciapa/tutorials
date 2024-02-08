package com.github.marcinciapa.chapter5.problem122;

import java.util.Collection;

interface CollectionHolder<T extends Collection<ValueHolder>> {

    T getCollection();
}
