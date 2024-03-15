package com.github.marcinciapa.chapter14.problem199;

import static java.util.Objects.isNull;

class SelfInventedThreadWrapper implements ThreadWrapper {

    private final Thread thread;

    public SelfInventedThreadWrapper(Runnable runnable) {
        if (isNull(runnable)) {
            throw new IllegalArgumentException();
        }
        this.thread = new Thread(runnable);
    }

    @Override
    public Thread.State getState() {
        return thread.getState();
    }

    @Override
    public void start() {
        thread.start();
    }
}
