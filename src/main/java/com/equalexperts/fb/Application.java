package com.equalexperts.fb;

import com.equalexperts.fb.calculator.ChainedCalculator;
import com.equalexperts.fb.fizzbuzz.FizzBuzzer;
import com.equalexperts.fb.output.FizzBuzzResults;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to Fizz-Buzz");
        System.out.println("--------------------");
        System.out.println("");

        FizzBuzzer fizzBuzzer = new FizzBuzzer(new ChainedCalculator());

        new FizzBuzzResults().printResults(fizzBuzzer.generateFizzBuzz(100));
    }
}
