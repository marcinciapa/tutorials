package com.github.marcinciapa.chapter2.problem53;

class ConstructorShallowCopyableObject extends CopyableObject implements ShallowCopyableObject {

    ConstructorShallowCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    private ConstructorShallowCopyableObject(ConstructorShallowCopyableObject original) {
        this(original.x, original.y, original.z);
    }

    @Override
    ConstructorShallowCopyableObject copy() {
        return new ConstructorShallowCopyableObject(this);
    }
}
