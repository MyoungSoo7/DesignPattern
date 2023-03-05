package com.backend.bakckend.designpattern.state;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



class Memento {
    int money;
    ArrayList<String> fruits;

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<String>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    public int getMoney() {
        return money;
    }

}
class Gamer {
    private int money;
    private ArrayList<String> fruits = new ArrayList<String>();
    private Random random = new Random();
    private static String[] fruitsname = {
            "사과", "포도", "바나나", "귤"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("소지금이 증가했습니다.");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("소지금이 절반이 되었습니다.");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("과일(" + f + ")을 받았습니다.");
            fruits.add(f);
        } else {
            System.out.println("변한 것이 없습니다.");
        }
    }

    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();
            if (f.startsWith("맛있는")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {  // undo 를 실행한다
        this.money = memento.money;
        this.fruits = memento.fruits;
    }

    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "맛있는";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }

}


public class MementoTest {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        ArrayList<Memento> history = new ArrayList<Memento>();
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("현상: " + gamer);

            gamer.bet();

            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println(" (많이 증가했으므로 현재의 상태를 저장하고 다시 게임을 시작합니다.)");
                memento = gamer.createMemento();
                history.add(memento);
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println(" (많이 감소했으므로 이전의 상태로 복원하고 다시 게임을 시작합니다.)");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}
