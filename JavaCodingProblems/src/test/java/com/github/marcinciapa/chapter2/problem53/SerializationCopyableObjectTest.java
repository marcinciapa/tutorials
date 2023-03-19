package com.github.marcinciapa.chapter2.problem53;

class SerializationCopyableObjectTest extends DeepCopyableObjectTest<SerializationCopyableObject> {

    @Override
    SerializationCopyableObject createInstance(int x, int y, int z) {
        return new SerializationCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
