package com.github.marcinciapa.chapter2.problem53;

import org.apache.commons.lang3.SerializationUtils;

class ApacheUtilsCopyableObject extends SerializableCopyableObject {

    ApacheUtilsCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    ApacheUtilsCopyableObject copy() {
        return SerializationUtils.clone(this);
    }
}
