package com.github.marcinciapa.chapter5.problem118;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

class EvenSplitter {


    Map<Boolean, List<Integer>> splitEvensFromOdds(List<Integer> input) {
        return input.stream()
                .collect(partitioningBy(number -> number % 2 == 0));
    }
}
