package com.equalexperts.fb.calculator;

import com.equalexperts.fb.classify.*;
import com.equalexperts.fb.exception.NonPositiveNumberException;

public class ChainedCalculator implements FizzBuzzCalculator {
    private Classifier root;

    public ChainedCalculator() {
        root = new FizzBuzzClassifier();

        root.registerNext(new FizzClassifier())
                .registerNext(new BuzzClassifier())
                .registerNext(new NumberClassifier());
    }

    public String calculateFromNumber(Integer numberToCheck) throws NonPositiveNumberException {
        if (numberToCheck < 1) {
            throw new NonPositiveNumberException(
                    String.format("Number to check cannot be negative [%s]", numberToCheck.toString()));
        }

        return root.getStringFromNumber(numberToCheck);
    }
}
