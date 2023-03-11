package com.backend.bakckend.designpattern.waste;


interface Printable {
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}

class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy() {
    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}

class Printer implements Printable{
    private String name;
    public Printer() {
        heavyJob("Printer의 인스턴스를 생성 중");
    }
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer의 인스턴스(" + name + ")을 생성 중");
    }
    public void setPrinterName(String name) {
        this.name = name;
    }
    public String getPrinterName() {
        return name;
    }
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("완료.");
    }

}


public class Proxy {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.setPrinterName("Bob");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.print("Hello, world.");
    }
}
