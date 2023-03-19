package com.github.marcinciapa.chapter2.problem53;

class ConstructorDeepCopyableObject extends CopyableObject implements DeepCopyableObject {

    ConstructorDeepCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    private ConstructorDeepCopyableObject(ConstructorDeepCopyableObject original) {
        this(original.getX(), original.getY(), new CopyableNestedObject(original.getZ()));
    }

    @Override
    ConstructorDeepCopyableObject copy() {
        return new ConstructorDeepCopyableObject(this);
    }
}
