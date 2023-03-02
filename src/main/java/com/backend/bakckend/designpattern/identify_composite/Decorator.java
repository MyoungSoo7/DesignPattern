package com.backend.bakckend.designpattern.identify_composite;


abstract class Coffee{

    public abstract void brewing();
}

class EtiopiaAmericano extends Coffee{

    @Override
    public void brewing() {
        System.out.println("EtiopiaAmericano");
    }
}

class KeynaAmericano extends Coffee{

    @Override
    public void brewing() {
        System.out.println("KeynaAmericano");
    }
}

abstract class DecoratorPattern extends Coffee{
    Coffee coffee;

    public DecoratorPattern(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public void brewing() {
        coffee.brewing();
    }
}

class Latte extends DecoratorPattern{

    public Latte(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("Adding Milk");
    }
}

class Mocha extends DecoratorPattern{

    public Mocha(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("Adding Mocha Syrup");
    }
}

class WhippedCream extends DecoratorPattern{

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("Adding Whipped Cream");
    }
}

public class Decorator {

    public static void main(String[] args) {

        Coffee kenyaAmerikano = new KeynaAmericano();
        kenyaAmerikano.brewing();
        System.out.println();

        Coffee kenyaLatte = new Latte(kenyaAmerikano);
        kenyaLatte.brewing();
        System.out.println();

        Mocha kenyaMocha = new Mocha(new Latte(new KeynaAmericano()));
        kenyaMocha.brewing();
        System.out.println();

        WhippedCream etiopiaWhippedMocha = new WhippedCream(new Mocha(new Latte(new EtiopiaAmericano())));
        etiopiaWhippedMocha.brewing();
        System.out.println();


    }


}
