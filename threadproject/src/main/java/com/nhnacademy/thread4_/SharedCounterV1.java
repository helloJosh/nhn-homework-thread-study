package com.nhnacademy.thread4_;

public class SharedCounterV1 extends Thread{    
    SharedCountV0 sharedCount;
    int count;
    int maxCount;

    public SharedCounterV1(String name, int maxCount, SharedCountV0 sharedCount) {
        setName(name);
        this.sharedCount = sharedCount;
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            count++;
            synchronized(sharedCount){
                sharedCount.increment();
            }
        }
    }
    // sychronized object에 접근할수있냐없냐로 정ㅇ해진다
}
