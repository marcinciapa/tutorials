package com.github.marcinciapa.chapter1.problem26;

class SuggestedSummarizer implements Summarizer {

    @Override
    public int sum(int number1, int number2) {
        return Math.addExact(number1, number2);
    }
}
