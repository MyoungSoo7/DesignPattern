package com.backend.bakckend.spring.javaspring.singleton;

public class Car {

    public static Car getInstance(){
        return new Car();
    }
}
