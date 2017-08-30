package com.equalexperts.fb.fizzbuzz;

import com.equalexperts.fb.calculator.FizzBuzzCalculator;

import java.util.stream.IntStream;

public class FizzBuzzer {
    private FizzBuzzCalculator calculator;

    public FizzBuzzer(FizzBuzzCalculator calculator) {
        this.calculator = calculator;
    }

    public String[] generateFizzBuzz(Integer numberToGenerate) throws RuntimeException {
        return IntStream.rangeClosed(1, numberToGenerate)
                .mapToObj(i -> calculator.calculateFromNumber(i))
                .toArray(String[]::new);
    }
}
