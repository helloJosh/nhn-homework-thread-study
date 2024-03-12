package com.nhnacademy.thread4_;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Livelock {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Livelock livelock = new Livelock();
        new Thread(livelock::operation1,"T1").start();
        new Thread(livelock::operation2,"T2").start();
    }
    public void operation1(){
        try{
            while (true) {
                lock1.tryLock(50,TimeUnit.MILLISECONDS);
                System.out.println("lock1 acquired");
                Thread.sleep(1000);
                System.out.println("executing first operation.");
                lock1.unlock();
                Thread.sleep(10);   
            }
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public void operation2() {
        try{
            while (true) {
                lock2.tryLock(50,TimeUnit.MILLISECONDS);
                System.out.println("lock2 acquired");
                Thread.sleep(1000);
                System.out.println("executing second operation.");
                lock2.unlock();
                Thread.sleep(10);   
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        
        }
    }
}

