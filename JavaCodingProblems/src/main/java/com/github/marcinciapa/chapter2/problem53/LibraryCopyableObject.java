package com.github.marcinciapa.chapter2.problem53;

import com.rits.cloning.Cloner;

class LibraryCopyableObject extends CopyableObject implements DeepCopyableObject{

    LibraryCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    LibraryCopyableObject copy() {
        Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }
}
