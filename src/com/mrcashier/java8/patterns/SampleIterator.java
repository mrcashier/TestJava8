package com.mrcashier.java8.patterns;

import java.util.Arrays;
import java.util.List;

/**
 * User: ccajero
 * Date: 25/02/16
 * Time: 05:28 PM
 */
public class SampleIterator {

    public static void main(String[] args) {
        // external iterators
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        for(int i=0; i<numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        for (Integer number : numbers) {
            System.out.println(number);
        }

        // internal iterators
        numbers.forEach(e -> System.out.println(e));

        numbers.forEach(System.out::println);
    }
}
