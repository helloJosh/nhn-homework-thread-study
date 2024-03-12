package com.nhnacademy.thread4_;

public class SharedCountV0Main {
    public static void main(String[] args) throws InterruptedException {        
        SharedCountV0 sharedCount = new SharedCountV0();
        SharedCounterV0 counter1 = new SharedCounterV0("counter1", 10000, sharedCount);
        SharedCounterV0 counter2 = new SharedCounterV0("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();
        System.out.println(counter1.getName() + ": started");
        System.out.println(counter2.getName() + ": started");

        counter1.join();
        counter2.join();
        System.out.println(counter1.getName() + ": terminated");
        System.out.println(counter2.getName() + ": terminated");

        System.out.println("sharedCount : " + sharedCount.getCount());

    }
}
