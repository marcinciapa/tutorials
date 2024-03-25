package com.github.marcinciapa.chapter14.problem203;

import com.github.marcinciapa.chapter14.bulbs.AssemblyLine;
import com.github.marcinciapa.chapter14.bulbs.Bulb;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MultiThreadedAssemblyLine implements AssemblyLine {

    private static final int TESTERS = 3;
    private static final int PACKERS = 2;

    private final ExecutorService testers = Executors.newFixedThreadPool(TESTERS);
    private final ExecutorService packers = Executors.newFixedThreadPool(PACKERS);

    @Override
    public Collection<Bulb> assembly(Collection<? extends Bulb> bulbs) {
        ConcurrentLinkedQueue<? extends Bulb> incomingQueue = new ConcurrentLinkedQueue<>(bulbs);
        List<Bulb> packedBulbs = Collections.synchronizedList(new LinkedList<>());
        ConcurrentLinkedQueue<Bulb> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < TESTERS; ++i) {
            testers.submit(() -> {
                while (true) {
                    Bulb bulbToTest = incomingQueue.poll();
                    if (bulbToTest == null) {
                        System.out.println("Testing bulbs finished");
                        break;
                    }
                    queue.offer(bulbToTest.checked());
                    System.out.printf("Tested bulb %d passed for packaging%n", bulbToTest.id());
                }
            });
        }

        for (int i = 0; i < PACKERS; ++i) {
            packers.submit(() -> {
                while (packedBulbs.size() < bulbs.size()) {
                    Bulb bulbToPack = queue.poll();
                    if (bulbToPack != null) {
                        packedBulbs.add(bulbToPack.packed());
                        System.out.printf("Bulb %d packed%n", bulbToPack.packed().id());
                    }
                }

                System.out.println("Packing bulbs finished");
            });
        }


        try {
            testers.shutdown();
            packers.shutdown();
            testers.awaitTermination(10, TimeUnit.SECONDS);
            packers.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            testers.shutdownNow();
            packers.shutdownNow();
            throw new RuntimeException(e);
        }

        return packedBulbs;
    }
}
