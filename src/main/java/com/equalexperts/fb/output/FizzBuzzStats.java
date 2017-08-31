package com.equalexperts.fb.output;

import java.util.Arrays;

public class FizzBuzzStats implements FizzBuzzOutputter {
    @Override
    public void printResults(String[] results) {
        System.out.println(String.format(
                "fizz: %s buzz: %s fizzbuzz: %s lucky: %s integer: %s",
                Arrays.stream(results).filter(s -> s.equals("fizz")).count(),
                Arrays.stream(results).filter(s -> s.equals("buzz")).count(),
                Arrays.stream(results).filter(s -> s.equals("fizzbuzz")).count(),
                Arrays.stream(results).filter(s -> s.equals("lucky")).count(),
                Arrays.stream(results).filter(s -> {
                    try {
                        Integer.parseInt(s);
                        return true;
                    } catch(NumberFormatException e) {
                        return false;
                    }
                }).count()));
    }
}
