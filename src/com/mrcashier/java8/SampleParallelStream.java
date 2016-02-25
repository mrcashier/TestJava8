package com.mrcashier.java8;

import java.util.Arrays;
import java.util.List;

/**
 * User: ccajero
 * Date: 24/02/16
 * Time: 01:06 PM
 */
public class SampleParallelStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Timeit.code(() ->
            System.out.println(
                    //numbers.stream()
                    numbers.parallelStream()  // Stream vs parallelStream
                            .filter(e -> e % 2 == 0)
                            .mapToInt(SampleParallelStream::compute)
                            .sum()
            )
        );

        // given an ordered list find the double of the first even number greater than 3
        int result = 0;
        for(int n: numbers) {
            if(n > 3 && n % 2 == 0 ) {
                result = n * 2;
                break;
            }
        }
        System.out.println(result);


        System.out.println(
                numbers.stream()
                    .filter(e -> e > 3)
                    .filter(e -> e % 2 == 0)
                    .map(e -> e * 2)
                    .findFirst()
        );

    }

    public static int compute(int number) {
        //try { Thread.sleep(1000);} catch (InterruptedException e) {}
        return number * 2;
    }
}

class Timeit {
    public static void code(Runnable code) {
        long start = System.nanoTime();
        try {
            code.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken: " + (end - start)/1.0e9);
        }
    }
}
