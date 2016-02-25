package com.mrcashier.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SampleMethodParameters {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //external iterators
        for (Integer number : numbers)
            System.out.println(number);

        for(int i=0; i<numbers.size(); i++)
            System.out.println(numbers.get(i));

        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        numbers.forEach((Integer v) -> System.out.println(v));

        numbers.forEach((v) -> System.out.println(v));

        numbers.forEach(v  -> System.out.println(v));

        numbers.forEach(System.out::println);


        numbers.stream()
                .map(e -> Integer.toString(e))
                .forEach(System.out::println);

        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);

        numbers.stream()
                .map(e -> e.toString())
                .map(e -> Integer.valueOf(e))
                .forEach(System.out::println);

        numbers.stream()
                .map(String::valueOf)
                .map(Integer::valueOf)
                .map(e -> e.intValue())
                .forEach(System.out::println);

        System.out.println(
                numbers.stream()
                         .reduce(0, (total, e) -> Integer.sum(total, e))
        );

        System.out.println(
                numbers.stream()
                        .reduce(0, Integer::sum)
        );

        System.out.println(
                numbers.stream()
                    .map(String::valueOf)
                    //.reduce("", (carry, str) -> carry.concat(str))
                    .reduce("", String::concat)
        );

    }
}
