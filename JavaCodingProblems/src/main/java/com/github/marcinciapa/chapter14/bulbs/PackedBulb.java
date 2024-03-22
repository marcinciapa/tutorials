package com.github.marcinciapa.chapter14.bulbs;

public record PackedBulb(Bulb bulb) implements Bulb {

    @Override
    public boolean isChecked() {
        return bulb.isChecked();
    }

    @Override
    public boolean isPacked() {
        return true;
    }

    @Override
    public int id() {
        return bulb.id();
    }
}
