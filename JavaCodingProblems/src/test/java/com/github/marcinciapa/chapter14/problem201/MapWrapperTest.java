package com.github.marcinciapa.chapter14.problem201;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapWrapperTest {

    @Test
    void shouldOperateWithSingleThreadPool() throws InterruptedException {
        // given
        MapWrapper map = new MapWrapper();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            map.increment(threadName);
        };

        // when
        for (int i = 0; i < 100; ++i) {
            executorService.submit(runnable);
        }
        executorService.awaitTermination(1, SECONDS);

        // then
        assertEquals(1, map.countKeys());
        assertEquals(100, map.cumulatedValues());
    }

    @Test
    void shouldOperateWithMultiThreadPool() throws InterruptedException {
        // given
        MapWrapper map = new MapWrapper();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            map.increment(threadName);
        };

        // when
        for (int i = 0; i < 100; ++i) {
            executorService.submit(runnable);
        }
        executorService.awaitTermination(1, SECONDS);

        // then
        assertEquals(5, map.countKeys());
        assertEquals(100, map.cumulatedValues());
    }
}