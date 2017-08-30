package com.equalexperts.fb.classify;

import org.junit.Before;
import org.junit.Test;
import uk.org.fyodor.generators.RDG;
import uk.org.fyodor.range.Range;

import static org.assertj.core.api.Assertions.*;

public class NumberClassifierTest {

    private Classifier numberClassifierToTest;

    @Before
    public void before() {
        numberClassifierToTest = new NumberClassifier();
    }

    @Test
    public void anyPositiveNumberReturnsSameStringRepresentation() {
        // Given
        Integer randomValue = RDG.integer(Range.closed(1, Integer.MAX_VALUE)).next();

        // When
        String result = numberClassifierToTest.getStringFromNumber(randomValue);

        // Then
        assertThat(result).isInstanceOfAny(String.class).isEqualTo(Integer.toString(randomValue));
    }
}