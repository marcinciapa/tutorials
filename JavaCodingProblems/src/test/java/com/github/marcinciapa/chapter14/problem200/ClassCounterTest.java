package com.github.marcinciapa.chapter14.problem200;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassCounterTest {

    @Test
    void shouldIncrementCounterConcurrentlyAndGetValue() throws InterruptedException {
        // given
        int concurrentIncrements = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(concurrentIncrements);

        // when
        for (int i = 0; i < concurrentIncrements; ++i) {
            executorService.submit(ClassCounter::increment);
        }
        executorService.awaitTermination(1, SECONDS);

        // then
        assertEquals(concurrentIncrements, ClassCounter.value());
    }
}
