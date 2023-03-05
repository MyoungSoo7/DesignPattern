package com.backend.bakckend.designpattern.state;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

interface Observer {
    abstract void update(NumberGenerator generator);
}

abstract class NumberGenerator{
    private List<Observer> observers = new ArrayList<Observer>();
    void addObserver(Observer observer) {
        observers.add(observer);
    }
    void deleteObserver(Observer observer) {
        observers.remove(observer);
    }
    void notifyObservers() {
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer o = it.next();
            o.update(this);
        }
    }
    abstract int getNumber(); // 숫자를 가져옴
    abstract void execute();  // 숫자를 생성하고 Observer에 통지
}

class RandomNumberGenerator extends NumberGenerator{
    private Random random = new Random();

    private int number;

    @Override
    int getNumber() {
        return number;
    }

    @Override
    void execute() {
        for (int i = 0; i < 20; i++) {
            number = (int) (Math.random() * 50);
            notifyObservers();
        }
    }
}

class DigitObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class GraphObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ObserverTest {

    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }


}
