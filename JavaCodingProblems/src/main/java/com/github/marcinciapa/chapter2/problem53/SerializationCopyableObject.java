package com.github.marcinciapa.chapter2.problem53;

import java.io.*;

class SerializationCopyableObject extends CopyableObject implements DeepCopyableObject, Serializable {

    SerializationCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    @Override
    SerializationCopyableObject copy() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            return (SerializationCopyableObject) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
