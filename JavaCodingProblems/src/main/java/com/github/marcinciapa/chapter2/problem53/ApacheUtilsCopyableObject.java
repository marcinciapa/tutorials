package com.github.marcinciapa.chapter2.problem53;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class ApacheUtilsCopyableObject extends CopyableObject implements DeepCopyableObject, Serializable {

    ApacheUtilsCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    ApacheUtilsCopyableObject copy() {
        return SerializationUtils.clone(this);
    }
}
