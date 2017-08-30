package com.equalexperts.fb.classify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuzzClassifierTest {

    @Mock
    private Classifier mockedClassifier;
    private Integer maxRandomNumber = 10000;

    private Classifier buzzClassifierToTest;

    @Before
    public void before() {
        buzzClassifierToTest = new BuzzClassifier();
        buzzClassifierToTest.registerNext(mockedClassifier);
    }

    @Test
    public void valueOfFiveReturnsStringBuzz() {
        // Given
        Integer valueToTest = 5;

        // When
        String result = buzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("buzz");
    }

    @Test
    public void anyMultipleOfFiveReturnsStringBuzz() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, maxRandomNumber)).next() * 5;

        // When
        String result = buzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("buzz");
    }

    @Test
    public void anyNonDivisibleByFiveValueCallsNextGetStringFromNumberOnly() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 4)).next();

        // When
        buzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(any(Integer.class));
    }

    @Test
    public void anyNonDivisibleByFiveCallNextGetStringFromNumberWithPassedValue() {
        // Given
        Integer valueToTest = RDG.integer(Range.closed(1, 4)).next();

        // When
        buzzClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(eq(valueToTest));
    }
}