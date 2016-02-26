package com.mrcashier.java8.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * User: ccajero
 * Date: 25/02/16
 * Time: 05:57 PM
 */
public class SampleDecorator {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;

        doWork(10, inc);
        doWork(10, doubleIt);
    }

    public static void doWork(int value, Function<Integer, Integer> func) {
        System.out.println(func.apply(value));
    }
}
