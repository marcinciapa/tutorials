package com.github.marcinciapa.chapter2.problem53;

class ApacheUtilsCopyableObjectTest extends DeepCopyableObjectTest<ApacheUtilsCopyableObject> {

    @Override
    ApacheUtilsCopyableObject createInstance(int x, int y, int z) {
        return new ApacheUtilsCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
