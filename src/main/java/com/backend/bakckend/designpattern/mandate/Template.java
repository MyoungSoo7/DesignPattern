package com.backend.bakckend.designpattern.mandate;



abstract class PlayerLevel{

    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();

    final public void go(int count){
        run();
        for(int i = 0; i < count; i++){
            jump();
        }
        turn();
    }

}

class BeginnerLevel extends PlayerLevel{

    @Override
    public void run() {
        System.out.println("천천히 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("jump 할 줄 모릅니다.");
    }

    @Override
    public void turn() {
        System.out.println("turn 할 줄 모릅니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("***** 초급자 레벨입니다. *****");
    }
}

class AdvancedLevel extends PlayerLevel{

    @Override
    public void run() {
        System.out.println("빨리 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("jump 합니다.");
    }

    @Override
    public void turn() {
        System.out.println("turn 합니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("***** 중급자 레벨입니다. *****");
    }
}

class SuperLevel extends PlayerLevel{

    @Override
    public void run() {
        System.out.println("엄청 빨리 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("아주 높이 jump 합니다.");
    }

    @Override
    public void turn() {
        System.out.println("turn 합니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("***** 고급자 레벨입니다. *****");
    }
}

public class Template {

    public static void main(String[] args) {
        PlayerLevel playerLevel = new BeginnerLevel();
        playerLevel.showLevelMessage();
        playerLevel.go(1);

        PlayerLevel playerLevel1 = new AdvancedLevel();
        playerLevel1.showLevelMessage();
        playerLevel1.go(2);

        PlayerLevel playerLevel2 = new SuperLevel();
        playerLevel2.showLevelMessage();
        playerLevel2.go(3);
    }
}
