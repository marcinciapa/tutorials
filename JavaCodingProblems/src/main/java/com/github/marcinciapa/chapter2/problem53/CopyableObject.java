package com.github.marcinciapa.chapter2.problem53;

abstract class CopyableObject {

    protected int x;
    protected int y;
    protected CopyableNestedObject z;

    protected CopyableObject(int x, int y, CopyableNestedObject z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    protected CopyableObject(){}

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    int getZ() {
        return this.z.getZ();
    }

    void setZ(int z) {
        this.z.setZ(z);
    }

    abstract <T extends CopyableObject> T copy();
}
