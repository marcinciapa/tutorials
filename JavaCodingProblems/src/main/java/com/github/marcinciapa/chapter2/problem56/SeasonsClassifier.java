package com.github.marcinciapa.chapter2.problem56;

class SeasonsClassifier {

    boolean isWarmAndPretty(Season season) {
        if (season == null) {
            throw new IllegalArgumentException();
        }

        return switch(season) {
            case SPRING, SUMMER -> true;
            case FALL, WINTER -> false;
        };
    }
}
