package com.equalexperts.fb.classify;

public abstract class Classifier {
    protected Classifier next;

    public Classifier registerNext(Classifier nextClassifier) {
        this.next = nextClassifier;
        return next;
    }

    public abstract String getStringFromNumber(Integer numberToCheck);
}
