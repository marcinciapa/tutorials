package com.github.marcinciapa.chapter1.problem35;

class SelfInventedFloorCalculatorTest extends FloorCalculatorTest<SelfInventedFloorCalculator>{

    @Override
    SelfInventedFloorCalculator createInstance() {
        return new SelfInventedFloorCalculator();
    }
}
