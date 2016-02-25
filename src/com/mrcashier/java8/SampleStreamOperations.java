package com.mrcashier.java8;

import java.util.Arrays;
import java.util.List;

/**
 * User: ccajero
 * Date: 24/02/16
 * Time: 01:26 PM
 */
public class SampleStreamOperations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // filter   - output values <= input values
        // map      - transform values
        // reduce   - cut across values of collection

        System.out.println(
            numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2.0f)
                .reduce(0.0f, Float::sum)
        );

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToDouble(e -> e * 2.0f)
                //.forEach(e-> System.out.println(e));
                .forEach(System.out::println);

    }
}
