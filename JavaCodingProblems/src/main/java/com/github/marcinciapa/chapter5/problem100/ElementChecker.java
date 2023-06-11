package com.github.marcinciapa.chapter5.problem100;

import java.util.Comparator;

interface ElementChecker {

    <T> boolean contains(T element, T[] array, Comparator<T> comparator);
}
