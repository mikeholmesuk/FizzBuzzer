package com.equalexperts.fb.classify;

import com.equalexperts.fb.predicate.Numeric;

public class FizzBuzzClassifier extends Classifier {
    public String getStringFromNumber(Integer numberToCheck) {
        return Numeric.isDivisibleBy(15).test(numberToCheck)
                ? "fizzbuzz"
                : next.getStringFromNumber(numberToCheck);
    }
}
