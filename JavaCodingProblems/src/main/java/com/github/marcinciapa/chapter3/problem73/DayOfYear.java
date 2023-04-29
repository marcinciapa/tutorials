package com.github.marcinciapa.chapter3.problem73;

record DayOfYear(int year, int month, int day) {

    @Override
    public String toString() {
        return "%d-%d-%d".formatted(year, month, day);
    }
}
