package com.equalexperts.fb.classify;

import com.equalexperts.fb.predicate.Numeric;

public class FizzClassifier extends Classifier {
    public String getStringFromNumber(Integer numberToCheck) {
        return Numeric.isDivisibleBy(3).test(numberToCheck)
                ? "fizz"
                : next.getStringFromNumber(numberToCheck);
    }
}
