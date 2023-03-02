package com.backend.bakckend.designpattern.separate;


// strategy pattern
interface MovableStragegy {
    void move();
}

// startegy1
class RailLoadStrategy implements MovableStragegy {
    @Override
    public void move() {
        System.out.println("Train is moving by rails");
    }
}

// startegy2
class LoadStrategy implements MovableStragegy {
    @Override
    public void move() {
        System.out.println("Load is moving by roads");
    }
}

// strategy target
class Moving{
    private MovableStragegy movableStragegy;

    void move(){
        movableStragegy.move();
    }

    void setMovableStragegy(MovableStragegy movableStragegy){
        this.movableStragegy = movableStragegy;
    }
}


// strategy taget of object1
class Train extends Moving{
    @Override
    public void move() {
        System.out.println("Train is moving by rails");
    }
}


// strategy taget of object2
class Bus extends Moving{
    @Override
    public void move() {
        System.out.println("Bus is moving by roads");
    }
}

public class Strategy {

    public static void main(String[] args) {
        Moving train = new Train();
        Moving bus = new Bus();

        train.setMovableStragegy(new RailLoadStrategy());
        bus.setMovableStragegy(new LoadStrategy());


    }
}
