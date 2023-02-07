package com.github.marcinciapa.chapter1.problem35;

class SuggestedFloorCalculator implements FloorCalculator {

    @Override
    public int floorDivision(int dividend, int divisor) {
        return Math.floorDiv(dividend, divisor);
    }

    @Override
    public int floorModulus(int dividend, int divisor) {
        return Math.floorMod(dividend, divisor);
    }
}
