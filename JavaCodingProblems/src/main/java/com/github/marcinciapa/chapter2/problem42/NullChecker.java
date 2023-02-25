package com.github.marcinciapa.chapter2.problem42;

interface NullChecker {

    <T> T requireNonNullOrThrow(T object);
}
