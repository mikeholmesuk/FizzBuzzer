package com.equalexperts.fb.predicate;

import java.util.function.Predicate;

public class Numeric {
    public static Predicate<Integer> isDivisibleBy(Integer divisibleNumber) {
        return i -> i % divisibleNumber == 0;
    }

    public static Predicate<Integer> containsDigit(Integer number) {
        return i -> Integer.toString(i).indexOf(Integer.toString(number)) >= 0;
    }
}
