package com.github.marcinciapa.chapter2.problem48;

class ImmutableStringsHolder {

    private String string1;
    private String string2;

    ImmutableStringsHolder(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    String getString1() {
        return string1;
    }

    String getString2() {
        return string2;
    }
}
