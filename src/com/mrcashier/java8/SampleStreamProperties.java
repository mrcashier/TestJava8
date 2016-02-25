package com.mrcashier.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mrcashier on 2/24/16.
 */
public class SampleStreamProperties {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        // sized, ordered, non-distinct, non-sorted
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        //sorted
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        // distinct
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .distinct()
                .forEach(System.out::println);

    }
}
