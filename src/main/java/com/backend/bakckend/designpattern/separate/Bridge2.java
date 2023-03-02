package com.backend.bakckend.designpattern.separate;


interface HuntingHandler{
    void Find_Quarry();
    void Chase_Quarry();
    void Attack_Quarry();

}


class Hunting1 implements HuntingHandler{
    public void Find_Quarry(){
        System.out.println("Find_Quarry1");
    }

    public void Chase_Quarry(){
        System.out.println("Chase_Quarry1");
    }

    public void Attack_Quarry(){
        System.out.println("Attack_Quarry1");
    }

}

class Hunting2 implements HuntingHandler{
    public void Find_Quarry(){
        System.out.println("Find_Quarry2");
    }
    public void Chase_Quarry(){
        System.out.println("Chase_Quarry2");
    }
    public void Attack_Quarry(){
        System.out.println("Attack_Quarry2");
    }
}

class Animal{
    private HuntingHandler huntingHandler;

    public Animal(HuntingHandler huntingHandler){
        this.huntingHandler = huntingHandler;
    }

    void Find_Quarry(){
        huntingHandler.Find_Quarry();
    }

    void Chase_Quarry(){
        huntingHandler.Chase_Quarry();
    }

    void Attack_Quarry(){
        huntingHandler.Attack_Quarry();
    }

    void Hunt(){
        Find_Quarry();
        Chase_Quarry();
        Attack_Quarry();
    }

}

class Tiger extends Animal{
    public Tiger(HuntingHandler huntingHandler){
        super(huntingHandler);
    }

    void hunt(){
        System.out.println("Tiger is hunting");
        Find_Quarry();
        Chase_Quarry();
        Attack_Quarry();
        super.Hunt();
    }
}

class Bird extends Animal{
    public Bird(HuntingHandler huntingHandler){
        super(huntingHandler);
    }

    void hunt(){
        System.out.println("Bird is hunting");
        Find_Quarry();
        Chase_Quarry();
        Attack_Quarry();
        super.Hunt();
    }
}

public class Bridge2 {


    public static void main(String[] args) {

        // hunting method bridge
        Animal tiger = new Tiger(new Hunting1());
        Animal bird = new Bird(new Hunting2());

        tiger.Hunt();
        System.out.println("==================================");
        bird.Hunt();


    }

}
