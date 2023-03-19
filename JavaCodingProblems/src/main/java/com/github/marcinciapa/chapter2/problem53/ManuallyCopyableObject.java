package com.github.marcinciapa.chapter2.problem53;

class ManuallyCopyableObject extends CopyableObject implements ShallowCopyableObject {

    ManuallyCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    ManuallyCopyableObject copy() {
        return new ManuallyCopyableObject(x, y, z);
    }
}
