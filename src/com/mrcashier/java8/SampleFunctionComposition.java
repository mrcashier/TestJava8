package com.mrcashier.java8;

import java.util.Arrays;
import java.util.List;

/**
 * User: ccajero
 * Date: 24/02/16
 * Time: 12:12 PM
 */
public class SampleFunctionComposition {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // given de values, double the even numbers and total
        int result = 0;
        for(int e: numbers) {
            if (e % 2 == 0)
                result += e*2;
        }
        System.out.println(result);

        System.out.println(
                numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .reduce(0, (total, e) -> total + (e*2))
        );

        System.out.println(
                numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .map(e -> e * 2)
                    .reduce(0, Integer::sum)
        );

        System.out.println(
                numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .mapToInt(e -> e * 2)
                    .sum()
        );


    }
}
