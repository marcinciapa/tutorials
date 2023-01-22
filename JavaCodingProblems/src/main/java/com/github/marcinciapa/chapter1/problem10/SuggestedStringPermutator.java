package com.github.marcinciapa.chapter1.problem10;

import java.util.List;

class SuggestedStringPermutator implements StringPermutator {

    private final SelfInventedStringPermutator selfInventedPermutator = new SelfInventedStringPermutator();

    @Override
    public List<String> generatePermutations(String input) {
        return selfInventedPermutator.getPermutations(input);
    }
}
