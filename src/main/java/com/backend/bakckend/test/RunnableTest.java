package com.backend.bakckend.test;

public class RunnableTest {
    public static void main(String[] args) {
        Thread thd = new Thread(() -> System.out.println("my thread"));
        thd.start();
    }

}
