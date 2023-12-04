package com.backend.bakckend.javalecturesparta.condition;

//wait() & notify()의 문제점인 waiting pool 내 쓰레드를 구분하지 못한다는 것을 해결한 것이 Condition 입니다.
//     wait()과 notify()는 객체에 대한 모니터링 락(lock)을 이용하여 스레드를 대기시키고 깨웁니다.
//     그러나 wait()과 notify()는 **waiting pool 내에 대기중인 스레드를 구분하지 못하므로**,
//     특정 조건을 만족하는 스레드만 깨우기가 어렵습니다.
//   이러한 문제를 해결하기 위해 JDK 5에서는 java.util.concurrent.locks 패키지에서 Condition 인터페이스를 제공합니다.
//   Condition은 waiting pool 내의 스레드를 분리하여
//   특정 조건이 만족될 때만 깨우도록 할 수 있으며,
//   ReentrantLock 클래스와 함께 사용됩니다.
//   따라서 Condition을 사용하면 wait()과 notify()의 문제점을 보완할 수 있습니다.

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    Object lock1 = new Object();
    Object lock2 = new Object();
    ReentrantLock lock = new ReentrantLock();
    // lock으로 condition 생성
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    ArrayList<String> tasks = new ArrayList<>();

    public void addMethod(String task) {
        lock.lock(); // 임계영역 시작

        try {
            while (tasks.size() >= 5) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    condition1.await(); // wait(); condition1 쓰레드를 기다리게 합니다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            tasks.add(task);
            condition2.signal(); // notify();  기다리고 있는 condition2를 깨워줍니다.
            System.out.println("Tasks:" + tasks.toString());
        } finally {
            lock.unlock(); // 임계영역 끝
        }
    }


}
