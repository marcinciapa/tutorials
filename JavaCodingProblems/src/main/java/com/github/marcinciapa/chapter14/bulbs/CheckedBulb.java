package com.github.marcinciapa.chapter14.bulbs;

public record CheckedBulb(Bulb bulb) implements Bulb {

    @Override
    public boolean isChecked() {
        return true;
    }

    @Override
    public boolean isPacked() {
        return false;
    }

    @Override
    public int id() {
        return bulb.id();
    }
}
