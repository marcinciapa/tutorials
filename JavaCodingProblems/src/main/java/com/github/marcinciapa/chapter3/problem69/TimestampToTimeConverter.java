package com.github.marcinciapa.chapter3.problem69;

interface TimestampToTimeConverter<T> {

    T convert(long timestamp);
}
