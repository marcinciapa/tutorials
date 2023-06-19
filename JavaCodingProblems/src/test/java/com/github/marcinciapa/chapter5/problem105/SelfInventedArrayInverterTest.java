package com.github.marcinciapa.chapter5.problem105;

class SelfInventedArrayInverterTest extends ArrayInverterTest<SelfInventedArrayInverter> {

    @Override
    SelfInventedArrayInverter inverter() {
        return new SelfInventedArrayInverter();
    }
}
