package com.mrcashier.java8.patterns;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * User: ccajero
 * Date: 25/02/16
 * Time: 06:52 PM
 */
public class SampleFluentInterfaces {
    public static void main(String[] args) {
        new Mailer()
            .from("ccajero@gmail.com")
            .to("mrcashier@outlook.com")
            .subject("New Code")
            .body("body from mail")
            .send();

        System.out.println("--");

        MailerStatic.send(mailer -> mailer
                .from("ccajero@gmail.com")
                .to("mrcashier@outlook.com")
                .subject("New Code")
                .body("body from mail"));

    }

}

class Mailer {

    public static void  print(String msg) { System.out.println(msg); }

//    public void from(String addr) { print("from"); }
//    public void to(String to) { print("to"); }
//    public void subject(String subject) { print("subject"); }
//    public void body(String body) { print("body"); }

    public Mailer from(String addr) { print("from"); return this; }
    public Mailer to(String to) { print("to"); return this; }
    public Mailer subject(String subject) { print("subject"); return this; }
    public Mailer body(String body) { print("body"); return this; }

    public void send() { print("sending..."); }

}

class MailerStatic {

    public static void  print(String msg) { System.out.println(msg); }

//    public void from(String addr) { print("from"); }
//    public void to(String to) { print("to"); }
//    public void subject(String subject) { print("subject"); }
//    public void body(String body) { print("body"); }

    public MailerStatic from(String addr) { print("from"); return this; }
    public MailerStatic to(String to) { print("to"); return this; }
    public MailerStatic subject(String subject) { print("subject"); return this; }
    public MailerStatic body(String body) { print("body"); return this; }

    public static void send(Consumer<MailerStatic> block) {
        MailerStatic mailer = new MailerStatic();
        block.accept(mailer);
        print("sending...");
    }

}