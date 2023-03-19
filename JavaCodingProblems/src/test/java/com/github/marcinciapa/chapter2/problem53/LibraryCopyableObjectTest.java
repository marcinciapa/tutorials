package com.github.marcinciapa.chapter2.problem53;

class LibraryCopyableObjectTest extends DeepCopyableObjectTest<LibraryCopyableObject>{

    @Override
    LibraryCopyableObject createInstance(int x, int y, int z) {
        return new LibraryCopyableObject(x, y, new CopyableNestedObject(z));
    }
}
