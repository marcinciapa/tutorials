package com.github.marcinciapa.chapter2.problem57;

class SeasonsConverter {

    String convert(Season season) {
        if (season == null) {
            throw new IllegalArgumentException();
        }
        return switch(season) {
            case SPRING -> {
                System.out.println("Its warm and pretty");
                yield "Spring";
            }
            case SUMMER -> {
                System.out.println("It's hot and pretty");
                yield "Summer";
            }
            case FALL -> {
                System.out.println("It's warm and ugly");
                yield "Fall";
            }
            case WINTER -> {
                System.out.println("It's cold and ugly");
                yield "Winter";
            }

        };
    }
}
