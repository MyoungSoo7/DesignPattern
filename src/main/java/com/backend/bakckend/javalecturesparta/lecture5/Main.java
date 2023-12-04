package com.backend.bakckend.javalecturesparta.lecture5;

public class Main {

    public static void main(String[] args) {
/*
            TestThread thestThread = new TestThread();
            thestThread.start();
*/
        Runnable run = new TestRunnable();


        Runnable task = () ->{
            int sum =0;
            for (int i=0; i<50;i++){
                sum +=i;
                System.out.println(sum);
            }
            System.out.println(Thread.currentThread().getName() +"최종합 : "+sum);
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
