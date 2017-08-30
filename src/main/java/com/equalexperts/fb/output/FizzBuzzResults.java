package com.equalexperts.fb.output;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FizzBuzzResults implements FizzBuzzOutputter {

    public void printResults(String[] results) {
        System.out.println(Arrays.stream(results).collect(Collectors.joining(" ")));
    }
}
