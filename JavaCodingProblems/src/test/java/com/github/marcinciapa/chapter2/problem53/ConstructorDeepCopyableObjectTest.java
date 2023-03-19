package com.github.marcinciapa.chapter2.problem53;

class ConstructorDeepCopyableObjectTest extends DeepCopyableObjectTest<ConstructorDeepCopyableObject> {

    @Override
    ConstructorDeepCopyableObject createInstance(int x, int y, int z) {
        return new ConstructorDeepCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
