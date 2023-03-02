package com.backend.bakckend.designpattern.instance;



interface AbstractComputerFactory {
    Keyboard createKeyboard();
    Mouse createMouse();
}

class SamsungComputerFactory implements AbstractComputerFactory {

    @Override
    public Keyboard createKeyboard() {
        return new SamsungKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new SamsungMouse();
    }

}

class LgComputerFactory implements AbstractComputerFactory {

    @Override
    public Keyboard createKeyboard() {
        return new LgKeyboard();
    }

    @Override
    public Mouse createMouse() {
        return new LgMouse();
    }

}

class FactoryOfComputerFactory{
     void createComputerFactory(String type) {

         AbstractComputerFactory computerFactory = null;

        if(type.equals("lg")){
            computerFactory = new LgComputerFactory();
        }else if(type.equals("samsung")){
             computerFactory= new SamsungComputerFactory();
        }

        computerFactory.createKeyboard();
        computerFactory.createMouse();

    }

}

public class AbstractFactory {
    public static void main(String[] args) {
        FactoryOfComputerFactory factoryOfComputerFactory = new FactoryOfComputerFactory();
        factoryOfComputerFactory.createComputerFactory("lg");
        factoryOfComputerFactory.createComputerFactory("samsung");
    }


}
