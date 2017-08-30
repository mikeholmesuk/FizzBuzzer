package com.equalexperts.fb.classify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzClassifierTest {

    @Mock
    private Classifier mockedClassifier;
    private Integer maxRandomNumber = 10000;

    private Classifier fizzBuzzClassifierToTest;

    @Before
    public void before() {
        fizzBuzzClassifierToTest = new FizzBuzzClassifier();
        fizzBuzzClassifierToTest.registerNext(mockedClassifier);
    }

    @Test
    public void valueOfFifteenReturnsStringFizzBuzz() {
        // Given
        Integer valueToTest = 15;

        // When
        String result = fizzBuzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("fizzbuzz");
    }

    @Test
    public void anyMultipleOfFifteenReturnsStringFizzBuzz() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, maxRandomNumber)).next() * 15;

        // When
        String result = fizzBuzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("fizzbuzz");
    }

    @Test
    public void anyNonDivisibleByFifteenValueCallsNextGetStringFromNumberOnly() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 14)).next();

        // When
        fizzBuzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(any(Integer.class));
    }

    @Test
    public void anyNonDivisibleByFifteenCallNextGetStringFromNumberWithPassedValue() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 2)).next();

        // When
        fizzBuzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(eq(valueToTest));
    }
}