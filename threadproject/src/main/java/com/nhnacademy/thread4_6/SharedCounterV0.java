package com.nhnacademy.thread4_;

public class SharedCounterV0 extends Thread{    
    SharedCountV0 sharedCount;
    int count;
    int maxCount;

    public SharedCounterV0(String name, int maxCount, SharedCountV0 sharedCount) {
        setName(name);
        this.sharedCount = sharedCount;
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            count++;
            sharedCount.increment();
        }
    }
}
