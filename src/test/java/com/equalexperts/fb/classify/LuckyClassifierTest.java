package com.equalexperts.fb.classify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LuckyClassifierTest {

    @Mock
    private Classifier mockedClassifier;

    private Classifier luckyClassifierToTest;

    @Before
    public void before() {
        luckyClassifierToTest = new LuckyClassifier();
        luckyClassifierToTest.registerNext(mockedClassifier);
    }

    @Test
    public void numberBeginningWithThreeReturnsStringLucky() {
        // Given
        Integer valueToTest = 31;

        // When
        String result = luckyClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("lucky");
    }

    @Test
    public void numberEndingWithThreeReturnsStringLucky() {
        // Given
        Integer valueToTest = 13;

        // When
        String result = luckyClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("lucky");
    }

    @Test
    public void numberWithThreeInMiddleReturnsStringLucky() {
        // Given
        Integer valueToTest = 116583871;

        // When
        String result = luckyClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        assertThat(result).isInstanceOf(String.class).isEqualTo("lucky");
    }

    @Test
    public void numberNotContainingThreeCallsNextGetStringFromNumberWithPassedValue() {
        // Given
        Integer valueToTest = 12456789;

        // When
        luckyClassifierToTest.getStringFromNumber(valueToTest);

        // Then
        verify(mockedClassifier, only()).getStringFromNumber(eq(valueToTest));
    }
}