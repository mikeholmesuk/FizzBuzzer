package com.equalexperts.fb.classify;

public class NumberClassifier extends Classifier {
    public String getStringFromNumber(Integer numberToCheck) {
        return Integer.toString(numberToCheck);
    }
}
