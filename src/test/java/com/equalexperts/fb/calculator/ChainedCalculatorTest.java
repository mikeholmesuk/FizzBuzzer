package com.equalexperts.fb.calculator;

import com.equalexperts.fb.exception.NonPositiveNumberException;
import org.junit.Before;
import org.junit.Test;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import static org.assertj.core.api.Assertions.*;

public class ChainedCalculatorTest {

    private FizzBuzzCalculator chainedCalculator;
    private Integer maxRandomNumber = 10000;

    @Before
    public void before() {
        chainedCalculator = new ChainedCalculator();
    }

    @Test(expected = NonPositiveNumberException.class)
    public void nonPositiveNumberThrowsNonPositiveNumberException() {
        // Given
        Integer negativeValue = RDG.integer(Range.closed(Integer.MIN_VALUE, 0)).next();

        // When
        chainedCalculator.calculateFromNumber(negativeValue);

        // Then
        // Throws Exception
    }

    @Test(expected = NonPositiveNumberException.class)
    public void numberZeroThrowsNonPositiveNumberException() {
        // Given
        Integer negativeValue = 0;

        // When
        chainedCalculator.calculateFromNumber(negativeValue);

        // Then
        // Throws Exception
    }

    @Test
    public void numberThreeReturnsFizz() {
        // Given
        Integer valueToTest = 3;

        // When
        String result = chainedCalculator.calculateFromNumber(valueToTest);

        // Then
        assertThat(result).isEqualTo("fizz");
    }


    @Test
    public void numberFiveNumberReturnsBuzz() {
        // Given
        Integer valueToTest = 5;

        // When
        String result = chainedCalculator.calculateFromNumber(valueToTest);

        // Then
        assertThat(result).isEqualTo("buzz");
    }

    @Test
    public void anyPositiveNumberDivisibleByFifteenReturnsFizzBuzz() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, maxRandomNumber)).next() * 15;

        // When
        String result = chainedCalculator.calculateFromNumber(valueToTest);

        // Then
        assertThat(result).isEqualTo("fizzbuzz");
    }

    @Test
    public void nonEligibleDivisibleNumberReturnsNumberAsString() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 2)).next();

        // When
        String result = chainedCalculator.calculateFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo(Integer.toString(valueToTest));
    }
}