package com.github.marcinciapa.chapter2.problem53;

import java.io.*;

abstract class SerializableCopyableObject extends CopyableObject implements DeepCopyableObject, Serializable {

    SerializableCopyableObject(int x, int y, CopyableNestedObject z) {
        super(x, y, z);
    }

    // This method must exist, because superclass and composite class are not serializable:
    // https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/examples/nonserialsuper/index3.html
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        // for serializable class (this):
        out.defaultWriteObject();
        // for non-serializable parts: superclass and composite
        out.writeInt(getX());
        out.writeInt(getY());
        out.writeInt(getZ());
    }

    // This method must exist, because superclass and composite class are not serializable:
    // https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/examples/nonserialsuper/index3.html
    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // for serializable class (this):
        in.defaultReadObject();
        // for non-serializable parts: superclass and composite
        setX(in.readInt());
        setY(in.readInt());
        z = new CopyableNestedObject(in.readInt());
    }
}
