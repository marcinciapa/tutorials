package com.github.marcinciapa.chapter5.problem122;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CollectionHolderTest<T extends Collection<ValueHolder>> {

    private static final int THREAD_COUNT = 5;

    abstract CollectionHolder<T> getHolder();

    @Test
    void shouldIncrementAllElementsAndAddNew() throws Exception {
        Callable<Void> callable = () -> {
            for (int i = 0; i < 100; ++i) {
                long value = Thread.currentThread().getId();
                long count = getHolder().getCollection()
                        .stream()
                        .filter(val -> val.value() == value)
                        .count();

                assertEquals(i, count);

                ValueHolder newValue = new ValueHolder(i, value);
                getHolder().getCollection().add(newValue);
            }

            return null;
        };

        List<Future<Void>> submitted = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; ++i) {
            submitted.add(executorService.submit(callable));
        }

        for (Future<Void> future : submitted) {
            future.get();
        }
    }
}
