package com.nhnacademy.thread1_3;

import java.time.LocalDate;
import java.time.LocalTime;

public class RunnableCounter implements Runnable{
    String name;
    int count;
    int maxCount;
    public RunnableCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
        count =0;
    }

    @Override
    public void run(){
        while(count < maxCount){
            try{
                Thread.sleep(1000);
                count++;
                System.out.println(name +":"+count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        RunnableCounter counter1 = new RunnableCounter("counter1", 10);
        RunnableCounter counter2 = new RunnableCounter("counter2", 10);
        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);

        System.out.println("start :" + now);

        thread1.start();
        thread2.start();
        
        while(thread1.isAlive() || thread2.isAlive())
            ;
        System.out.println("end :" + now);
    }

}
