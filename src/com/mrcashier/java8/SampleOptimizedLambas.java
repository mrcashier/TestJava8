package com.mrcashier.java8;

import java.util.Arrays;
import java.util.List;

public class SampleOptimizedLambas {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(
            numbers.stream()
                    .filter(SampleOptimizedLambas::isGT3)
                    .filter(SampleOptimizedLambas::isEven)
                    .map(SampleOptimizedLambas::doubleIt)
                    .findFirst()
        );

    }

    public static boolean isGT3(int e) {
        System.out.println("is greater than 3, " + e);
        return e > 3;
    }

    public static boolean isEven(int e) {
        System.out.println("is even, " + e);
        return e % 2 == 0;
    }

    public static int doubleIt(int e) {
        System.out.println("doubleit, " + e);
        return e * 2;
    }
}
