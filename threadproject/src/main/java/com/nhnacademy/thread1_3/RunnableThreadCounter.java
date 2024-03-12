package com.nhnacademy.thread1_3;

import java.time.LocalDate;
import java.time.LocalTime;

public class RunnableThreadCounter implements Runnable{
    String name;
    int count;
    int maxCount;
    Thread thread;

    public RunnableThreadCounter(String name, int maxCount){
        this.name = name;
        this.maxCount = maxCount;
        count =0;
        thread = new Thread(this);
    }
    public void start(){
        thread.start();
    }
    public void stop(){
        //thread.currentThread().interrupt();
        thread.interrupt();
    }
    public Thread getThread(){
        return this.thread;
    }

    public int getCount(){
        return this.count;
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted() && count < maxCount){
            try{
                Thread.sleep(1000);
                count++;
                System.out.println(name +":"+count+"" + Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(name+": interrupted");
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread());
            }
        }
    }
    public static void main(String[] args) {
        RunnableThreadCounter[] counters = new RunnableThreadCounter[10];
        Thread[] threads = new Thread[10];
        LocalTime now = LocalTime.now();
        boolean allStopped = false;

        for(int i=0; i<counters.length ; i++){
                counters[i] = new RunnableThreadCounter("counter "+(i+1), 10);
                counters[i].getThread().start();
        }
        
        while(!allStopped){
            if((counters[0].getCount()>5)){
                for(int i=0;i<counters.length;i++){
                    counters[i].getThread().interrupt();
                }
            }
            allStopped = true;
            for(int i=0;i<counters.length;i++){
                if(counters[i].getThread().isAlive()){
                    allStopped = false;
                }
            }
        }
        System.out.println("end :" + now);
    }
}
