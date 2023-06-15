package com.github.marcinciapa.chapter5.problem101;

import java.util.Optional;

interface ArrayMismatchFinder {
    Optional<Integer> mismatch(int[] array1, int[] array2);
}
