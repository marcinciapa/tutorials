package com.github.marcinciapa.chapter2.problem53;

import com.rits.cloning.Cloner;

class LibraryDeepCopy {

    private int x;
    private int y;
    private InsightObject z;

    LibraryDeepCopy(int x, int y, InsightObject z) {
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

    static class InsightObject {
        private int z;

        InsightObject(int z) {
            this.z = z;
        }

        int getZ() {
            return z;
        }

        void setZ(int z) {
            this.z = z;
        }
    }
}
