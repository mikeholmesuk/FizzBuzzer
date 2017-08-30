package com.equalexperts.fb.fizzbuzz;

import com.equalexperts.fb.calculator.ChainedCalculator;
import com.equalexperts.fb.fizzbuzz.FizzBuzzer;
import org.assertj.core.api.ListAssert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FizzBuzzerTest {

    private FizzBuzzer fizzBuzzer;

    private String[] fizzBuzzSequence = {
            "1", "2", "fizz", "4", "buzz",
            "fizz", "7", "8", "fizz", "buzz",
            "11", "fizz", "13", "14", "fizzbuzz",
            "16", "17", "fizz", "19", "buzz"
    };

    @Before
    public void before() {
        fizzBuzzer = new FizzBuzzer(new ChainedCalculator());
    }

    @Test
    public void generatesCorrectFizzBuzzSequence() {
        // Given
        Integer numberToGenerate = 20;

        // When
        String[] result = fizzBuzzer.generateFizzBuzz(numberToGenerate);

        // Then
        assertThat(result).containsSequence(fizzBuzzSequence);
    }

    @Test
    public void firstDivisibleByThreeElementIsFizz() {
        // Given
        Integer numberToGenerate = 3;

        // When
        String[] result = fizzBuzzer.generateFizzBuzz(numberToGenerate);

        // Then
        assertThat(result).contains("fizz", atIndex(2));
    }

    @Test
    public void firstDivisibleByFiveElementIsBuzz() {
        // Given
        Integer numberToGenerate = 5;

        // When
        String[] result = fizzBuzzer.generateFizzBuzz(numberToGenerate);

        // Then
        assertThat(result).contains("buzz", atIndex(4));
    }

    @Test
    public void firstDivisibleByFifteenElementIsFizzBuzz() {
        // Given
        Integer numberToGenerate = 15;

        // When
        String[] result = fizzBuzzer.generateFizzBuzz(numberToGenerate);

        // Then
        assertThat(result).contains("fizzbuzz", atIndex(14));
    }
}