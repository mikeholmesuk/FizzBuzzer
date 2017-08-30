package com.equalexperts.fb.calculator;

import com.equalexperts.fb.exception.NonPositiveNumberException;

public interface FizzBuzzCalculator {
    String calculateFromNumber(Integer numberToCheck) throws NonPositiveNumberException;
}
