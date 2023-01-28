package com.github.marcinciapa.chapter1.problem32;

import static java.lang.Boolean.*;

class SuggestedBoolOperator implements BoolOperator {

    @Override
    public boolean and(boolean x, boolean y) {
        return logicalAnd(x, y);
    }

    @Override
    public boolean or(boolean x, boolean y) {
        return logicalOr(x, y);
    }

    @Override
    public boolean xor(boolean x, boolean y) {
        return logicalXor(x, y);
    }
}
