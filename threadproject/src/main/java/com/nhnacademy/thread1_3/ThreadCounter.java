package com.nhnacademy.thread1_3;

import java.time.LocalDate;
import java.time.LocalTime;

public class ThreadCounter extends Thread{
    String name;
    int count;
    int maxCount;
    public ThreadCounter(String name, int maxCount){
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
        ThreadCounter threadCounter1 = new ThreadCounter("counter1", 10);
        ThreadCounter threadCounter2 = new ThreadCounter("counter2", 10);

        System.out.println("start :" + now);
        threadCounter1.start();
        threadCounter2.start();
        System.out.println("end :" + now);
    }

}
