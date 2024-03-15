package com.github.marcinciapa.chapter14.problem199;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.lang.Thread.State.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ThreadWrapperTest<T extends ThreadWrapper> {

    abstract T wrap(Runnable runnable);

    @Test
    void shouldFailWhenWrappingNull() {
        assertThrows(IllegalArgumentException.class, () -> wrap(null));
    }

    @Test
    void shouldGetNewState() {
        // given
        T wrap = wrap(() -> {
        });

        // when
        Thread.State state = wrap.getState();

        // then
        assertEquals(NEW, state);
    }

    @Test
    void shouldGetRunnableState() {
        // given
        Runnable runnable = () -> {
            try {
                Thread.sleep(Duration.ofSeconds(10).toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        T wrapped = wrap(runnable);

        // when
        wrapped.start();

        // then
        assertEquals(RUNNABLE, wrapped.getState());
    }

    @Test
    void shouldGetBlockedState() throws InterruptedException {
        // given
        Runnable runnable = () -> {
            synchronized (this) {
                try {
                    Thread.sleep(Duration.ofSeconds(10).toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        T blocking = wrap(runnable);
        T blocked = wrap(runnable);

        // when
        blocking.start();
        Thread.sleep(Duration.ofSeconds(1).toMillis());
        blocked.start();
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // then
        assertEquals(BLOCKED, blocked.getState());
    }

    @Test
    void shouldGetWaitStatus() throws InterruptedException {
        // given
        Runnable runnable = () -> {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        T wrapped = wrap(runnable);

        // when
        wrapped.start();
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // then
        assertEquals(WAITING, wrapped.getState());
    }

    @Test
    void shouldGetTimedWaitStatus() throws InterruptedException {
        // given
        Runnable runnable = () -> {
            try {
                synchronized (this) {
                    wait(Duration.ofSeconds(2).toMillis());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        T wrapped = wrap(runnable);

        // when
        wrapped.start();
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // then
        assertEquals(TIMED_WAITING, wrapped.getState());
    }

    @Test
    void shouldGetTerminatedStatus() throws InterruptedException {
        Runnable runnable = () -> {
        };
        T wrapped = wrap(runnable);

        // when
        wrapped.start();
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // then
        assertEquals(TERMINATED, wrapped.getState());
    }
}
