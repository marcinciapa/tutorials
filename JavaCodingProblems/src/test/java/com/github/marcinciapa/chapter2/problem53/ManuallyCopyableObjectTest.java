package com.github.marcinciapa.chapter2.problem53;

class ManuallyCopyableObjectTest extends ShallowCopyableObjectTest<ManuallyCopyableObject> {

    @Override
    ManuallyCopyableObject createInstance(int x, int y, int z) {
        return new ManuallyCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
