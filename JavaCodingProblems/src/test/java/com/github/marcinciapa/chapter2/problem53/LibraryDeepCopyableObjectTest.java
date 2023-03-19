package com.github.marcinciapa.chapter2.problem53;

class LibraryDeepCopyableObjectTest extends DeepCopyableObjectTest<LibraryDeepCopyableObject>{

    @Override
    LibraryDeepCopyableObject createInstance(int x, int y, int z) {
        return new LibraryDeepCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
