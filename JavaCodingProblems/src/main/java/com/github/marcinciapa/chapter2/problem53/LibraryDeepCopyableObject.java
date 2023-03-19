package com.github.marcinciapa.chapter2.problem53;

import com.rits.cloning.Cloner;

class LibraryDeepCopyableObject extends CopyableObject implements DeepCopyableObject{

    LibraryDeepCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    LibraryDeepCopyableObject copy() {
        Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }
}
