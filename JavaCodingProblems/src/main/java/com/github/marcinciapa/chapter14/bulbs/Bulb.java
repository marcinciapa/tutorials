package com.github.marcinciapa.chapter14.bulbs;

import java.time.Duration;
import java.util.Random;

public interface Bulb {

    Duration MAX_CHECK_TIME = Duration.ofMillis(10);
    Duration MAX_PACKAGE_TIME = Duration.ofMillis(20);

    boolean isChecked();

    boolean isPacked();

    default Bulb checked() {
        Random random = new Random();
        var checkTime = random.nextLong(MAX_CHECK_TIME.toMillis());
        try {
            Thread.sleep(checkTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new CheckedBulb(this);
    }

    default Bulb packed() {
        Random random = new Random();
        var packageTime = random.nextLong(MAX_PACKAGE_TIME.toMillis());
        try {
            Thread.sleep(packageTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new PackedBulb(this);
    }

    int id();
}
