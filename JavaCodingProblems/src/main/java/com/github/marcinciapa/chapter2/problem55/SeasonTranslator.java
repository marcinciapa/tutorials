package com.github.marcinciapa.chapter2.problem55;

class SeasonTranslator {

    String translate(Season season) {
        if(season == null) {
            return "unknown";
        }
        return switch(season) {
            case SPRING -> "Spring";
            case SUMMER -> "Summer";
            case FALL -> "Fall";
            case WINTER -> "Winter";
        };
    }
}
