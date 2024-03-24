package com.github.marcinciapa.chapter14.problem202;

import com.github.marcinciapa.chapter14.bulbs.AssemblyLine;
import com.github.marcinciapa.chapter14.bulbs.Bulb;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

class NonBlockingAssemblyLine implements AssemblyLine {

    private final ExecutorService checker = Executors.newSingleThreadExecutor();
    private final ExecutorService packer = Executors.newSingleThreadExecutor();

    @Override
    public Collection<Bulb> assembly(Collection<? extends Bulb> bulbs) {

        List<Bulb> packedBulbs = Collections.synchronizedList(new LinkedList<>());
        Queue<Bulb> queue = new ConcurrentLinkedQueue<>();
        AtomicBoolean allTested = new AtomicBoolean(false);
        AtomicBoolean allPacked = new AtomicBoolean(false);

        checker.submit(() -> {
            for (Bulb bulb : bulbs) {
                queue.offer(bulb.checked());
                System.out.printf("Tested bulb %d passed for packaging%n", bulb.id());
            }
            allTested.set(true);
            System.out.println("Testing bulbs finished");
        });

        packer.submit(() -> {
            while (true) {
                Bulb bulb = queue.poll();
                if (bulb == null) {
                    if (allTested.get()) {
                        allPacked.set(true);
                        System.out.println("Packing bulbs finished");
                        break;
                    } else {
                        continue;
                    }
                }
                packedBulbs.add(bulb.packed());
                System.out.printf("Bulb %d packed%n", bulb.packed().id());
            }
        });

        do {
        } while (!allPacked.get());

        checker.shutdownNow();
        packer.shutdownNow();

        return packedBulbs;
    }
}
