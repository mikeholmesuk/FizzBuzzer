package com.equalexperts.fb.predicate;

import java.util.function.Predicate;

public class Numeric {
    public static Predicate<Integer> isDivisibleBy(Integer divisibleNumber) {
        return i -> i % divisibleNumber == 0;
    }
}
