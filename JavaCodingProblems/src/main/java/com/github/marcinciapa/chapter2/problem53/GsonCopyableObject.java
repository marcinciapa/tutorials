package com.github.marcinciapa.chapter2.problem53;

import com.google.gson.Gson;

class GsonCopyableObject extends CopyableObject implements DeepCopyableObject {

    GsonCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    GsonCopyableObject copy() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return gson.fromJson(json, this.getClass());
    }
}
