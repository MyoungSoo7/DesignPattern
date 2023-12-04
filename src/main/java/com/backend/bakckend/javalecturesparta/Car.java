package com.backend.bakckend.javalecturesparta;
public class Car {

    String company; // 자동차 회사
    private String model; // 자동차 모델
    private String color; // 자동차 색상
    private double price; // 자동차 가격

    double speed;  // 자동차 속도 , km/h
    char gear = 'P'; // 기어의 상태, P,R,N,D
    boolean lights; // 자동차 조명의 상태

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double gasPedal(double kmh, char type) {
        changeGear(type);
        speed = kmh;
        return speed;
    }

    public double brakePedal() {
        speed = 0;
        return speed;
    }

    public char changeGear(char type) {
        gear = type;
        return gear;
    }

    public boolean onOffLights() {
        lights = !lights;
        return lights;
    }

    public void horn() {
        System.out.println("빵빵");
    }

}