package com.nhnacademy;

import java.time.LocalTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter implements Runnable{
    public static final int MAX_COUNT = 10;
    Logger logger = LogManager.getLogger(getClass().getSimpleName());

    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for(int i=0 ; i < MAX_COUNT ;i++){
                Thread.sleep(1000);
                setName(getName()+1);
                logger.info("counter : {}", getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("start"+now);   
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        counter1.start();
        counter2.start();
        System.out.println("end"+now);
    }
}
