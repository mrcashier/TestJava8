package com.mrcashier.java8;

import java.util.stream.Stream;

/**
 * Created by mrcashier on 2/24/16.
 */
public class SampleInfiniteStream {

    public static void main(String[] args) {

        // Infinite Stream start with 100
        Stream.iterate(100, e -> e +1 );

        int k = 121;
        int n = 51;

        System.out.println(compute(k,n));
    }

    // Given a number k, and a count n, find the total of double of n
    // even numbers starting with k, where sqrt of each number is > 20
    public static int compute(int k, int n) {
//        int result = 0;
//        int count = 0;
//        int index = k;
//
//        while(count < n) {
//            if (index % 2 == 0 && Math.sqrt(index) > 20) {
//                result += index * 2;
//                count ++;
//            }
//
//            index++;
//        }
//
//        return result;

        return Stream.iterate(k, e -> e + 1)            // unbounded and lazy
                        .filter(e -> e % 2 == 0)        // unbounded and lazy
                        .filter(e -> Math.sqrt(e) > 20) // unbounded and lazy
                        .mapToInt(e -> e * 2)           // unbounded and lazy
                        .limit(n)                       // sized lazy
                        .sum();

    }
}
