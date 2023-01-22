package com.github.marcinciapa.chapter1.problem8;

class SuggestedWhitespaceRemover implements WhitespaceRemover{

    private final SelfInventedWhitespaceRemover selfInventedRemover = new SelfInventedWhitespaceRemover();

    @Override
    public String removeWhitespace(String inputString) {
        return selfInventedRemover.removeWhitespace(inputString);
    }
}
