package com.github.marcinciapa.chapter5.problem109;

import java.util.Collection;

interface UnmodifiableWrapper<T> {
    Collection<T> unmodifiable();
}
