package com.mrcashier.java8.patterns;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * User: ccajero
 * Date: 25/02/16
 * Time: 06:06 PM
 */
public class SampleDecorator2 {
    public static void main(String[] args) {
        printSnap(new Camera() );

        printSnap(new Camera(Color::brighter));
        printSnap(new Camera(Color::darker));

        System.out.println("--");
        printSnap(new Camera(Color::brighter, Color::darker));

        System.out.println("--");
        printSnap(new Camera(Color::darker, Color::brighter));
    }

    public static void printSnap(Camera camera) {
        System.out.println(camera.snap(new Color(125,125,125)));
    }
}

class Camera {

    private Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    public void setFilters(Function<Color, Color>... filters) {

        //filter = color -> color;
        filter = Stream.of(filters)
                    .reduce(
                            Function.identity(), //color -> color,
                            Function::andThen //(theFilters, aFilter) -> theFilters.andThen(aFilter)
                            );
    }

    public Color snap(Color input) {
        return filter.apply(input);
    }
}