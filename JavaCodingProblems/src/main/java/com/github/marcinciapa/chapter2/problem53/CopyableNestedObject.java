package com.github.marcinciapa.chapter2.problem53;

import java.io.Serializable;

class CopyableNestedObject {

    private int z;

    CopyableNestedObject(int z) {
        this.z = z;
    }

    int getZ() {
        return z;
    }

    void setZ(int z) {
        this.z = z;
    }
}
