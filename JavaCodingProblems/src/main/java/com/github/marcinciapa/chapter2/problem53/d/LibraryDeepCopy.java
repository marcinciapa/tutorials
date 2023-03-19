package com.github.marcinciapa.chapter2.problem53.d;

import com.rits.cloning.Cloner;

class LibraryDeepCopy {

    private int x;
    private int y;
    private InsideObject z;

    LibraryDeepCopy(int x, int y, InsideObject z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

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
        return z.getZ();
    }

    void setZ(int z) {
        this.z.setZ(z);
    }

    LibraryDeepCopy copy() {
        Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }

}
