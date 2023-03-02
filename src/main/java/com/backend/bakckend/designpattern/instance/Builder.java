package com.backend.bakckend.designpattern.instance;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

abstract class Pizza{


    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder builder) {
        toppings = builder.toppings.clone();
    }

    public String toString(){
        return toppings.toString();
    }
}

class NyPizza extends Pizza{
    enum Size {SMALL, MEDIUM, LARGE};
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }
        public NyPizza build(){
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

class Calzone extends Pizza{
    private final boolean sauceInside;
    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauceInside = false;
        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }
        public Calzone build(){
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public String toString(){
        return toppings.toString() + "sauceInside: " + sauceInside;
    }

}

public class Builder {

    public static void main(String[] args) {
            Pizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                    .addTopping(Pizza.Topping.SAUSAGE)
                    .addTopping(Pizza.Topping.ONION)
                    .build();

            Pizza calzone = new Calzone.Builder()
                    .addTopping(Pizza.Topping.HAM)
                    .addTopping(Pizza.Topping.PEPPER)
                    .sauceInside()
                    .build();

        System.out.println(nyPizza);
        System.out.println(calzone);

    }
}
