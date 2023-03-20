package com.github.marcinciapa.chapter2.problem53;

class GsonCopyableObjectTest extends DeepCopyableObjectTest<GsonCopyableObject> {

    @Override
    GsonCopyableObject createInstance(int x, int y, int z) {
        return new GsonCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
