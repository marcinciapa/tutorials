package com.github.marcinciapa.chapter14.problem200;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectCounterTest {

    @Test
    void shouldIncrementCounterConcurrentlyAndGetValue() throws InterruptedException {
        // given
        int concurrentIncrements = 1000;
        ObjectCounter objectCounter = new ObjectCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(concurrentIncrements);

        // when
        for (int i = 0; i < concurrentIncrements; ++i) {
            executorService.submit(objectCounter::increment);
        }
        executorService.awaitTermination(1, SECONDS);

        // then
        assertEquals(concurrentIncrements, objectCounter.value());
    }
}
