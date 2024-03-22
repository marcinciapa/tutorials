package com.github.marcinciapa.chapter14.bulbs;

public record NewBulb(int id) implements Bulb {

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public boolean isPacked() {
        return false;
    }
}
