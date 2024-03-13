package com.nhnacademy.thread4_.state;

public class State{
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(()->{
            synchronized(lock){
                long count = 0;
                while(count < 10){
                    count ++;
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        Thread thread2 = new Thread(()->{
            synchronized(lock){
                long count = 0;
                while(count < 10){
                    count ++;
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                }
        }
        });
        System.out.println(thread1.getState());
        thread1.start();
        
        while(thread1.isAlive()){
            System.out.println(thread1.getState());
            Thread.sleep(1000);
        }

        System.out.println(thread1.getState());

        while(thread1.isAlive() || thread2.isAlive()){
            System.out.println(thread1.getState());
            System.out.println(thread2.getState());
            Thread.sleep(100);
        }

    }
}
