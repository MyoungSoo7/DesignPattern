package com.backend.bakckend.test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println("Hello "+x);
        consumer.accept("Java");

        Supplier<String> supplier = () -> "Hello Java";
        System.out.println(supplier.get());

        Function<String, Integer> function = (x) -> x.length();
        System.out.println(function.apply("Hello Java"));






    }
}
