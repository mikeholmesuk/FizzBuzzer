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
public class FizzClassifierTest {

    @Mock
    private Classifier mockedClassifier;
    private Integer maxRandomNumber = 10000;

    private Classifier fizzClassifierToTest;

    @Before
    public void before() {
        fizzClassifierToTest = new FizzClassifier();
        fizzClassifierToTest.registerNext(mockedClassifier);
    }

    @Test
    public void valueOfThreeReturnsStringFizz() {
        // Given
        Integer valueToTest = 3;

        // When
        String result = fizzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("fizz");
    }

    @Test
    public void anyMultipleOfThreeReturnsStringFizz() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, maxRandomNumber)).next() * 3;

        // When
        String result = fizzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("fizz");
    }

    @Test
    public void anyNonDivisibleByThreeValueCallsNextGetStringFromNumberOnly() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 2)).next();

        // When
        fizzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(any(Integer.class));
    }

    @Test
    public void anyNonDivisibleByThreeCallNextGetStringFromNumberWithPassedValue() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 2)).next();

        // When
        fizzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(eq(valueToTest));
    }
}