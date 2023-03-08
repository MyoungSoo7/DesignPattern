package com.backend.bakckend.designpattern.simple;


class Trouble{
    private int number;
    public Trouble(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public String toString() {
        return "[Trouble " + number + "]";
    }
}

 abstract class Support {
    private String name;
    private String next;

    //private Support nextSupport;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next.name;
        return next;
    }
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
           //next.support(trouble);
        } else {
            fail(trouble);
        }
    }
    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }

}

class LimitSupport extends Support {
    private int limit;
    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}

class SpecialSupport extends Support {
    private int number;
    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
}

class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}

class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}


public class Chain {

    public static void main(String[] args) {

        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);
        // 연쇄의 형성
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        // 다양한 트러블 발생
        for (int i = 0; i < 500; i+=33) {
            alice.support(new Trouble(i));
        }
    }
}
