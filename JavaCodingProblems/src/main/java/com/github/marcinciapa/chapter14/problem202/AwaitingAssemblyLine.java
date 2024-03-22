package com.github.marcinciapa.chapter14.problem202;

import com.github.marcinciapa.chapter14.bulbs.AssemblyLine;
import com.github.marcinciapa.chapter14.bulbs.Bulb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class AwaitingAssemblyLine implements AssemblyLine {

    private final ExecutorService checker = Executors.newSingleThreadExecutor();
    private final ExecutorService packer = Executors.newSingleThreadExecutor();

    @Override
    public Collection<Bulb> assembly(Collection<? extends Bulb> bulbs) {

        List<Bulb> packedBulbs = Collections.synchronizedList(new ArrayList<>());
        TransferQueue<Bulb> queue = new LinkedTransferQueue<>();

        checker.submit(() -> {
            for (Bulb bulb : bulbs) {
                try {
                    queue.tryTransfer(bulb.checked(), Bulb.MAX_PACKAGE_TIME.toMillis() + 10, MILLISECONDS);
                    System.out.printf("Tested bulb %d passed for packaging%n", bulb.id());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Checking worker timeout occurred while waiting for the bulb to be packed", e);
                }
            }
            System.out.println("Testing bulbs finished");
        });

        packer.submit(() -> {
            while (true) {
                try {
                    Bulb incomingBulb = queue.poll(Bulb.MAX_CHECK_TIME.toMillis() + 10, MILLISECONDS);
                    if (incomingBulb == null) {
                        System.out.println("Packing bulbs finished");
                        break;
                    }
                    Bulb packedBulb = incomingBulb.packed();
                    packedBulbs.add(packedBulb);
                    System.out.printf("Bulb %d packed%n", packedBulb.id());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Packaging worker timeout occurred while waiting for checked bulb", e);
                }
            }
        });

        checker.shutdown();
        packer.shutdown();
        try {
            boolean checkerTerminated = checker.awaitTermination(bulbs.size() * (Bulb.MAX_CHECK_TIME.toMillis() + Bulb.MAX_PACKAGE_TIME.toMillis()), MILLISECONDS);
            boolean packerTerminated = packer.awaitTermination(Bulb.MAX_PACKAGE_TIME.toMillis(), MILLISECONDS);
            if(!checkerTerminated) {
                checker.shutdownNow();
                checkerTerminated = checker.awaitTermination(bulbs.size() * (Bulb.MAX_CHECK_TIME.toMillis() + Bulb.MAX_PACKAGE_TIME.toMillis()), MILLISECONDS);
            }
            if(!packerTerminated) {
                packer.shutdownNow();
                packerTerminated = packer.awaitTermination(Bulb.MAX_PACKAGE_TIME.toMillis(), MILLISECONDS);
            }
            System.out.printf("Checker terminated: %b%nPacker terminated: %b%n", checkerTerminated, packerTerminated);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return packedBulbs;
    }

}
