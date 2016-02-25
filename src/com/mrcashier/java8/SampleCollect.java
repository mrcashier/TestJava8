package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SampleCollect {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        // 1. double the even values and punt into a list

        List<Integer> doubleOfEven = new ArrayList();

        // wrong way to do this
        // ATTENTION mutability is OK, sharing is nuce, shared mutability is devils work. HAHA
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e) );

        System.out.println(doubleOfEven);

        // OK WAY
        // List
        List<Integer> doubleOfEvenOK = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toList());

        System.out.println(doubleOfEvenOK);

        // Set
        Set<Integer> setDoubleOfEvenOK = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toSet());

        System.out.println(setDoubleOfEvenOK);

        // Map
        List<Person> persons  = Arrays.asList(
                new Person("Juan", Gender.MALE, 20),
                new Person("Carlos", Gender.MALE, 25),
                new Person("Maria", Gender.FEMALE, 30),
                new Person("Diana", Gender.FEMALE, 35),
                new Person("Maria", Gender.FEMALE, 40),
                new Person("Sofia", Gender.FEMALE, 21),
                new Person("Cristina", Gender.MALE, 22),
                new Person("Carlos", Gender.MALE, 23),
                new Person("Pedro", Gender.MALE, 50)
        );

        // Map with name and edge as key and person as value
        System.out.println(
                persons.stream()
                        .collect(toMap(
                                p -> p.getName().concat("-").concat(String.valueOf(p.getAge())),
                                p -> p
                        ))
        );

        // Given a list of people, create a map where their name is the key and value is a people with that name
        System.out.println(
                persons.stream()
                    .collect(groupingBy(Person::getName))
        );

        // Given a list of people, create a map where their name is the key and value is all the ages of people with that name
        System.out.println(
                persons.stream()
                        .collect(
                            groupingBy(Person::getName, mapping(Person::getAge, toList())))
        );
    }
}

enum Gender {
    MALE, FEMALE;
}
class Person {
    String name;
    Gender gender;
    int age;

    Person(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    String getName() {
        return name;
    }

    Gender getGender() {
        return gender;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}