package com.equalexperts.fb.predicate;

import org.junit.Test;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import static org.assertj.core.api.Assertions.*;

public class NumericTest {

    private Integer maxRandomNumber = 10000;

    @Test
    public void divByPositiveNumberReturnsTrueForSameNumber() {
        // Given
        Integer randomDivisible = RDG.integer(Range.closed(1, maxRandomNumber)).next();

        // When
        Boolean result = Numeric.isDivisibleBy(randomDivisible).test(randomDivisible);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void divByPositiveNumberReturnsTrueForZero() {
        // Given
        Integer randomDivisible = RDG.integer(Range.closed(1, maxRandomNumber)).next();

        // When
        Boolean result = Numeric.isDivisibleBy(randomDivisible).test(0);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void divByPositiveNumberReturnsTrueForAnyMultipleOfNumber() {
        // Given
        Integer randomDivisible = RDG.integer(Range.closed(1, maxRandomNumber)).next();
        Integer randomMultiplier = RDG.integer(Range.closed(1, maxRandomNumber)).next();

        // When
        Boolean result = Numeric.isDivisibleBy(randomDivisible).test(randomDivisible * randomMultiplier);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void divByPositiveNumberReturnsFalseForAnyNonDivisibleValue() {
        // Given
        Integer randomDivisible = RDG.integer(Range.closed(1, maxRandomNumber)).next();

        // When
        Boolean result = Numeric.isDivisibleBy(randomDivisible).test(randomDivisible - 1);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void containsDigitReturnsTrueIfNumberContainsRequestedDigitOnly() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(0, 9)).next();

        // When
        Boolean result = Numeric.containsDigit(valueToTest).test(valueToTest);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void containsDigitReturnsTrueIfNumberBeginsWithRequestedDigit() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(0, 9)).next();
        Integer randomisedNumber = Integer.parseInt(valueToTest.toString() + RDG.integer(Range.closed(0, maxRandomNumber)).next().toString());

        // When
        Boolean result = Numeric.containsDigit(valueToTest).test(randomisedNumber);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void containsDigitReturnsTrueIfNumberEndsWithRequestedDigit() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(0, 9)).next();
        Integer randomisedNumber = Integer.parseInt(RDG.integer(Range.closed(0, maxRandomNumber)).next().toString()+ valueToTest.toString());

        // When
        Boolean result = Numeric.containsDigit(valueToTest).test(randomisedNumber);

        // Then
        assertThat(result).isTrue();
    }
}