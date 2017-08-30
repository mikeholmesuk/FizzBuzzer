package com.equalexperts.fb.classify;

import com.equalexperts.fb.predicate.Numeric;

public class BuzzClassifier extends Classifier {
    public String getStringFromNumber(Integer numberToCheck) {
        return Numeric.isDivisibleBy(5).test(numberToCheck)
                ? "buzz"
                : next.getStringFromNumber(numberToCheck);
    }
}
