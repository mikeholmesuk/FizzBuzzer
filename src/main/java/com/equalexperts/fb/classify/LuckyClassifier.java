package com.equalexperts.fb.classify;

import com.equalexperts.fb.predicate.Numeric;

public class LuckyClassifier extends Classifier {
    public String getStringFromNumber(Integer numberToCheck) {
        return Numeric.containsDigit(3).test(numberToCheck)
                ? "lucky"
                : next.getStringFromNumber(numberToCheck);
    }
}
