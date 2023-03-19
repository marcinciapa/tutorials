package com.github.marcinciapa.chapter2.problem53;

class ConstructorShallowCopyableObjectTest extends ShallowCopyableObjectTest<ConstructorShallowCopyableObject> {

    @Override
    ConstructorShallowCopyableObject createInstance(int x, int y, int z) {
        return new ConstructorShallowCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
