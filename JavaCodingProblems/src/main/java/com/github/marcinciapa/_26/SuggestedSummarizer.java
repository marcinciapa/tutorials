package com.github.marcinciapa._26;

class SuggestedSummarizer implements Summarizer {

    @Override
    public int sum(int number1, int number2) {
        return Math.addExact(number1, number2);
    }
}
