package com.backend.bakckend.javalecturesparta.lecture5_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSynchronized {

    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        } finally {
            lock.unlock();
        }
    }
}

class Buffer{
    private int data;
    private boolean empty;

    public Buffer(){
        this.empty = true;
    }

    public synchronized void produce(int newData){
        while(!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = newData;
        empty = false;
        notifyAll();
    }

    public synchronized int consume(){
        while(empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return data;
    }
}