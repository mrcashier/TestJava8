package com.mrcashier.java8.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * User: ccajero
 * Date: 25/02/16
 * Time: 05:34 PM
 */
public class SampleStrategy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //total all values
        System.out.println(totalValues(numbers));

        //total even values
        System.out.println(totalEvenValues(numbers));

        // total odd values
        System.out.println(totalOddValues(numbers));

        //high-order function, recive a function and return a function
        System.out.println(totalValues(numbers, e -> true));
        System.out.println(totalValues(numbers, e -> e % 2 == 0));
        System.out.println(totalValues(numbers, e -> e % 2 != 0));

    }

    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        int result = 0;
        //for (Integer value : values) {
        //    if(selector.test(value))
        //        result += value;
        //}

        // result = values.stream()
        //                  .filter(selector::test)
        //                  .mapToInt(n -> n)
        //                  .sum();

        result = values.stream()
                        .filter(selector)
                        .reduce(0, Integer::sum);

        return result;

    }
    public static int totalValues(List<Integer> values) {
        int result = 0;
        for (Integer value : values) {
            result = result + value;
        }
        return result;
    }

    public static int totalEvenValues(List<Integer> values) {
        int result = 0;
        for (Integer value : values) {
            if(value % 2 == 0)
                result = result + value;
        }
        return result;
    }

    public static int totalOddValues(List<Integer> values) {
        int result = 0;
        for (Integer value : values) {
            if(value % 2 != 0)
                result = result + value;
        }
        return result;
    }

}
