package com.backend.bakckend.designpattern.mandate;


import java.util.HashMap;


// car abstract instance
abstract class Car{
    String carType;

    public String toString(){
        return carType;
    }
}



// car factory abstract instance
abstract class CarFactory{
    abstract Car createCar(String name);
    abstract Car returnMyCar(String name);
}



// Hyundai factory(CarFactory)
class HyundaiFactory extends CarFactory{

    HashMap<String,Car> carMap = new HashMap<String,Car>();

    @Override
    Car createCar(String name) {

        Car car = null;
        if(name.equals("sonata")){
            car = new Sonata(name);
        }else if(name.equals("santafe") ){
            car = new Santafe(name);
        }

        return car;
    }

    @Override
    Car returnMyCar(String name) {

        Car car = carMap.get(name);

        if(car==null){

            if(name.equals("James")){
                car = new Sonata(name);
            }else if(name.equals("Tomas")){
                car = new Santafe(name);
            }

            carMap.put(name, car);
        }
        return car;
    }
}

// Sonata(car)
class Sonata extends Car{
    Sonata(String name){
         carType = "sonata";
    }

}

// Santafe(car)
class Santafe extends Car{
    Santafe(String name){
        carType = "santafe";
    }

}

public class Factory {

    public static void main(String[] args) {

        CarFactory factory = new HyundaiFactory();
        Car car1 = factory.createCar("sonata");
        Car car2 = factory.createCar("santafe");

        System.out.println(car1);
        System.out.println(car2);

        Car myCar = factory.returnMyCar("James");
        Car hisCar = factory.returnMyCar("Tomas");

        System.out.println(myCar == hisCar);


    }

}
