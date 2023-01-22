package com.github.marcinciapa.chapter1.problem27;

class SuggestedIntParser implements IntParser {

    @Override
    public int parse(String number, int radix) {
        return Integer.parseUnsignedInt(number, radix);
    }
}
