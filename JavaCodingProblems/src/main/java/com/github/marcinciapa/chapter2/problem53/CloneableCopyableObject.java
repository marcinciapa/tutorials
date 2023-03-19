package com.github.marcinciapa.chapter2.problem53;

class CloneableCopyableObject extends CopyableObject implements ShallowCopyableObject, Cloneable {

    public CloneableCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    CloneableCopyableObject copy() {
        try {
            return (CloneableCopyableObject) this.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
