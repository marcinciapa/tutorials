package com.github.marcinciapa.chapter1.problem35;

class SelfInventedFloorCalculator implements FloorCalculator {

    @Override
    public int floorDivision(int dividend, int divisor) {
        int floor = (int) Math.floor(dividend / divisor);
        if(dividesWithRest(dividend, divisor) && exactlyOneIsNegative(dividend, divisor)) {
            return floor - 1;
        }
        return floor;
    }

    private static boolean exactlyOneIsNegative(int dividend, int divisor) {
        return dividend < 0 ^ divisor < 0;
    }

    private static boolean dividesWithRest(int dividend, int divisor) {
        return dividend % divisor != 0;
    }

    @Override
    public int floorModulus(int dividend, int divisor) {
        return dividend - (floorDivision(dividend, divisor) * divisor);
    }
}
