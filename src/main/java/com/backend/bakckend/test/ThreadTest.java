package com.backend.bakckend.test;

class MyThread extends Thread {
    Thread thdNext= null;
    public MyThread(String name){
        super(name);
    }
    public void run() {

        for(int i=0; i<100;i++){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " ");
                if(thdNext.isAlive()){
                    thdNext.interrupt();
                }
                e.printStackTrace();
            }
        }
    }
    public void setNextThread(Thread thdNext){
        this.thdNext = thdNext;
    }

    /*public void run() {
        System.out.println("MyThread");
        for(int i=0; i<1000;i++){
            System.out.println(getName());
            Thread.yield();
        }

    }*/
}

class MyThread2 implements Runnable {
    public void run() {
        System.out.println("MyThread2");
        for(int i=0; i<10;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class ThreadTest {

    public static void main(String[] args) {
        MyThread my_thread1 = new MyThread("thd1");
        MyThread my_thread2 = new MyThread("thd2");
        MyThread my_thread3 = new MyThread("thd3");
        my_thread1.setNextThread(my_thread2);
        my_thread2.setNextThread(my_thread3);
        my_thread3.setNextThread(my_thread1);
        my_thread1.start();
        my_thread2.start();
        my_thread3.start();
        try{
           my_thread1.interrupt();
           my_thread1.join();
           my_thread2.join();
           my_thread3.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");

      /*  Thread t1 = new MyThread(); t1.start();
        Thread t2 = new MyThread(); t2.start();

        t1.join();
        t2.join();
        System.out.println("main1");
*/


        /*Thread t3 = new Thread(new MyThread2(), "thd0"); t3.start();
        Thread t4 = new Thread(new MyThread2(), "thd1"); t4.start();
        System.out.println("main");*/
    }
}
