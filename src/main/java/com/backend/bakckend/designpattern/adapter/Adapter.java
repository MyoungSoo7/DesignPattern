package com.backend.bakckend.designpattern.adapter;



interface Print{
    abstract void printWeak();
    abstract void printStrong();
}

class Banner{
    private String string;
    public Banner(String string){
        this.string = string;
    }
    public void showWithParen(){
        System.out.println("(" + string + ")");
    }
    public void showWithAster(){
        System.out.println("*" + string + "*");
    }
}

class PrintBanner extends Banner implements Print{
    public PrintBanner(String string){
        super(string);
    }
    public void printWeak(){
        showWithParen();
    }
    public void printStrong(){
        showWithAster();
    }
}

public class Adapter {


    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
