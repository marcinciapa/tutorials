package com.github.marcinciapa.chapter14.problem199;

interface ThreadWrapper {

    Thread.State getState();

    void start();
}
