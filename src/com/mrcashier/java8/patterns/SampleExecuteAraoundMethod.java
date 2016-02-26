package com.mrcashier.java8.patterns;

import java.util.function.Consumer;

/**
 * User: ccajero
 * Date: 25/02/16
 * Time: 07:30 PM
 */
public class SampleExecuteAraoundMethod {
    public static void main(String[] args) {
        //Resource resource = new Resource();
        //resource.op1();
        //resource.op2();

        Resource.use(r -> r.op1()
                           .op2());

        Resource.use(Resource::op1);



    }
}

class Resource {
    private Resource() { System.out.println("created"); }

    public Resource op1() {System.out.println("op1"); return this; }
    public Resource op2() {System.out.println("op2"); return this; }

    private void close() {System.out.println("cleanup");}

    public static void use(Consumer<Resource> block) {
        Resource r = new Resource();
        try {
            block.accept(r);
        } finally {
            r.close();
        }

    }
}
