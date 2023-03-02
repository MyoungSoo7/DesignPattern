package com.backend.bakckend.designpattern.instance;


interface Keyboard {
    void create();
}

class LgKeyboard implements Keyboard {
    @Override
    public void create() {
        System.out.println("LgKeyboard Create");
    }
    public LgKeyboard() {
        System.out.println("LgKeyboard");
    }
}

class SamsungKeyboard implements Keyboard {

    public SamsungKeyboard() {
        System.out.println("SamsungKeyboard");
    }
    @Override
    public void create() {
        System.out.println("SamsungKeyboard create");
    }
}

class KeyboardFactory {
    public Keyboard createKeyboard(String type) {
        if(type.equals("lg"))
            return new LgKeyboard();
        else if(type.equals("samsung"))
            return new SamsungKeyboard();
        else
            return null;
    }
}

class LgMouse implements Mouse {
    @Override
    public void create() {
        System.out.println("LgMouse Create");
    }
    public LgMouse() {
        System.out.println("LgMouse");
    }
}

class SamsungMouse implements Mouse {

    public SamsungMouse() {
        System.out.println("SamsungMouse");
    }
    @Override
    public void create() {
        System.out.println("SamsungMouse create");
    }
}

interface Mouse {
    void create();
}

class MouseFactory{
    public Mouse createMouse(String type) {
        if(type.equals("lg"))
            return new LgMouse();
        else if(type.equals("samsung"))
            return new SamsungMouse();
        else
            return null;
    }
}


class ComputerFactory {
    public void createComputer(String type){
        KeyboardFactory keyboardFactory = new KeyboardFactory();
        MouseFactory mouseFactory = new MouseFactory();

        keyboardFactory.createKeyboard(type);
        mouseFactory.createMouse(type);

        System.out.println("----" +type + " 컴퓨터 완성 ----");
    }
}

public class Factory {

    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        computerFactory.createComputer("lg");
        computerFactory.createComputer("samsung");
    }
}
