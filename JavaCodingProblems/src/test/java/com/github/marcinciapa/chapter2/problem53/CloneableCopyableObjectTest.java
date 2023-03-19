package com.github.marcinciapa.chapter2.problem53;

class CloneableCopyableObjectTest extends ShallowCopyableObjectTest<CloneableCopyableObject> {

    @Override
    CloneableCopyableObject createInstance(int x, int y, int z) {
        return new CloneableCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
