package com.backend.bakckend.spring.javaspring.template;


import java.util.List;

public class CarTemplate {

    public static void main(String[] args) {
        Car aiCar = new AICar();
        aiCar.run();
        System.out.println("===============");
        Car manualCar = new MenualCar();
        manualCar.run();

    }
}
